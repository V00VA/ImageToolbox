package ru.tech.imageresizershrinker.data.saving

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.documentfile.provider.DocumentFile
import androidx.exifinterface.media.ExifInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.tech.imageresizershrinker.R
import ru.tech.imageresizershrinker.data.keys.Keys.ADD_ORIGINAL_NAME
import ru.tech.imageresizershrinker.data.keys.Keys.ADD_SEQ_NUM
import ru.tech.imageresizershrinker.data.keys.Keys.ADD_SIZE
import ru.tech.imageresizershrinker.data.keys.Keys.FILENAME_PREFIX
import ru.tech.imageresizershrinker.data.keys.Keys.SAVE_FOLDER
import ru.tech.imageresizershrinker.domain.image.Metadata
import ru.tech.imageresizershrinker.domain.saving.FileController
import ru.tech.imageresizershrinker.domain.saving.SaveTarget
import ru.tech.imageresizershrinker.domain.saving.model.FileParams
import ru.tech.imageresizershrinker.domain.saving.model.ImageSaveTarget
import ru.tech.imageresizershrinker.presentation.root.utils.permission.PermissionStatus
import ru.tech.imageresizershrinker.presentation.root.utils.permission.PermissionUtils.askUserToRequestPermissionExplicitly
import ru.tech.imageresizershrinker.presentation.root.utils.permission.PermissionUtils.checkPermissions
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import kotlin.random.Random

class FileControllerImpl @Inject constructor(
    private val context: Context,
    private val dataStore: DataStore<Preferences>
) : FileController {

    private var fileParams: FileParams = FileParams(
        treeUri = null,
        filenamePrefix = "",
        addSizeInFilename = false,
        addOriginalFilename = false,
        addSequenceNumber = false
    )

    init {
        CoroutineScope(Dispatchers.IO).launch {
            dataStore.data.collect {
                fileParams = fileParams.copy(
                    treeUri = it[SAVE_FOLDER],
                    filenamePrefix = it[FILENAME_PREFIX] ?: "",
                    addSizeInFilename = it[ADD_SIZE] ?: false,
                    addOriginalFilename = it[ADD_ORIGINAL_NAME] ?: false,
                    addSequenceNumber = it[ADD_SEQ_NUM] ?: true
                )
            }
        }
    }

    override fun isExternalStorageWritable(): Boolean = context.isExternalStorageWritable()

    private fun Context.isExternalStorageWritable(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) true
        else ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun requestReadWritePermissions() {
        context.findActivity()?.requestStoragePermission()
    }

    private fun Activity.requestStoragePermission() {
        val state = checkPermissions(
            listOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        )
        when (state.permissionStatus.values.first()) {
            PermissionStatus.NOT_GIVEN -> {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ),
                    0
                )
            }

            PermissionStatus.DENIED_PERMANENTLY -> {
                askUserToRequestPermissionExplicitly()
                Toast.makeText(this, R.string.grant_permission_manual, Toast.LENGTH_LONG).show()
            }

            PermissionStatus.ALLOWED -> Unit
        }
    }

    override fun getSize(uri: String): Long? = uri.toUri().fileSize(context)

    private fun Uri.fileSize(context: Context): Long? {
        context.contentResolver
            .query(this, null, null, null, null, null)
            .use { cursor ->
                if (cursor != null && cursor.moveToFirst()) {
                    val sizeIndex: Int = cursor.getColumnIndex(OpenableColumns.SIZE)
                    if (!cursor.isNull(sizeIndex)) {
                        return cursor.getLong(sizeIndex)
                    }
                }
            }
        return null
    }

    override val savingPath: String
        get() = fileParams.treeUri?.takeIf { it.isNotEmpty() }?.toUri().toUiPath(
            context = context,
            default = context.getString(R.string.default_folder)
        )

    private fun Uri?.toUiPath(context: Context, default: String): String = this?.let { uri ->
        DocumentFile
            .fromTreeUri(context, uri)
            ?.uri?.path?.split(":")
            ?.lastOrNull()?.let { p ->
                val endPath = p.takeIf {
                    it.isNotEmpty()
                }?.let { "/$it" } ?: ""
                val startPath = if (
                    uri.toString()
                        .split("%")[0]
                        .contains("primary")
                ) context.getString(R.string.device_storage)
                else context.getString(R.string.external_storage)

                startPath + endPath
            }
    } ?: default

    override suspend fun save(
        saveTarget: SaveTarget,
        keepMetadata: Boolean
    ) {
        kotlin.runCatching {
            var initialExif: ExifInterface? = null

            val savingFolder = context.getSavingFolder(
                treeUri = fileParams.treeUri?.takeIf { it.isNotEmpty() }?.toUri(),
                saveTarget = if (saveTarget is ImageSaveTarget<*>) {
                    initialExif = saveTarget.metadata as ExifInterface?

                    saveTarget.copy(
                        filename = constructFilename(
                            context = context,
                            fileParams = fileParams,
                            saveTarget = saveTarget
                        )
                    )
                } else saveTarget
            )

            savingFolder.outputStream?.use {
                it.write(saveTarget.data)
            }

            if (initialExif != null) {
                getFileDescriptorFor(savingFolder.fileUri)?.use {
                    val ex = ExifInterface(it.fileDescriptor)
                    initialExif.copyTo(ex)
                    ex.saveAttributes()
                }
            } else if (keepMetadata) {
                val exif = context
                    .contentResolver
                    .openFileDescriptor(saveTarget.originalUri.toUri(), "r")
                    ?.use { ExifInterface(it.fileDescriptor) }

                getFileDescriptorFor(savingFolder.fileUri)?.use {
                    val ex = ExifInterface(it.fileDescriptor)
                    exif?.copyTo(ex)
                    ex.saveAttributes()
                }
            } else null
        }.getOrNull() ?: dataStore.edit { it[SAVE_FOLDER] = "" }
    }

    private infix fun ExifInterface.copyTo(newExif: ExifInterface) {
        Metadata.metaTags.forEach { attr ->
            getAttribute(attr)?.let { newExif.setAttribute(attr, it) }
        }
        newExif.saveAttributes()
    }

    private data class SavingFolder(
        val outputStream: OutputStream? = null,
        val file: File? = null,
        val fileUri: Uri? = null,
    )

    private fun constructFilename(
        context: Context,
        fileParams: FileParams,
        saveTarget: ImageSaveTarget<*>
    ): String {
        val wh =
            "(" + (if (saveTarget.originalUri.toUri() == Uri.EMPTY) context.getString(R.string.width)
                .split(" ")[0] else saveTarget.imageInfo.width) + ")x(" + (if (saveTarget.originalUri.toUri() == Uri.EMPTY) context.getString(
                R.string.height
            ).split(" ")[0] else saveTarget.imageInfo.height) + ")"

        var prefix = fileParams.filenamePrefix
        val extension = saveTarget.imageInfo.imageFormat.extension

        if (prefix.isEmpty()) prefix = defaultPrefix()

        if (fileParams.addOriginalFilename) prefix += "_${
            if (saveTarget.originalUri.toUri() != Uri.EMPTY) {
                context.getFileName(saveTarget.originalUri.toUri()) ?: ""
            } else {
                context.getString(R.string.original_filename)
            }
        }"
        if (fileParams.addSizeInFilename) prefix += wh

        val timeStamp = SimpleDateFormat(
            "yyyy-MM-dd_HH-mm-ss",
            Locale.getDefault()
        ).format(Date()) + "_${Random(Random.nextInt()).hashCode().toString().take(4)}"
        return "${prefix}_${
            if (fileParams.addSequenceNumber && saveTarget.sequenceNumber != null) {
                SimpleDateFormat(
                    "yyyy-MM-dd_HH-mm-ss",
                    Locale.getDefault()
                ).format(Date()) + "_" + saveTarget.sequenceNumber
            } else if (saveTarget.originalUri.toUri() == Uri.EMPTY && fileParams.addSequenceNumber) {
                SimpleDateFormat(
                    "yyyy-MM-dd_HH-mm-ss",
                    Locale.getDefault()
                ).format(Date()) + "_" + context.getString(R.string.sequence_num)
            } else {
                timeStamp
            }
        }.$extension"
    }

    private fun getFileDescriptorFor(uri: Uri?) =
        uri?.let { context.contentResolver.openFileDescriptor(uri, "rw") }

    private fun defaultPrefix() = context.getString(R.string.default_prefix)

    private fun Context.getSavingFolder(
        treeUri: Uri?,
        saveTarget: SaveTarget
    ): SavingFolder {
        return if (treeUri == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val type = saveTarget.imageFormat.type
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, saveTarget.filename)
                    put(
                        MediaStore.MediaColumns.MIME_TYPE,
                        type
                    )
                    put(
                        MediaStore.MediaColumns.RELATIVE_PATH,
                        "DCIM/ResizedImages"
                    )
                }
                val imageUri = contentResolver.insert(
                    if ("image" in type) {
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    } else if ("video" in type) {
                        MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                    } else if ("audio" in type) {
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                    } else {
                        MediaStore.Files.getContentUri("external")
                    },
                    contentValues
                )

                SavingFolder(
                    outputStream = contentResolver.openOutputStream(imageUri!!),
                    fileUri = imageUri
                )
            } else {
                val imagesDir = File(
                    Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM
                    ), "ResizedImages"
                )
                if (!imagesDir.exists()) imagesDir.mkdir()
                SavingFolder(
                    outputStream = FileOutputStream(File(imagesDir, saveTarget.filename!!)),
                    fileUri = File(imagesDir, saveTarget.filename!!).toUri()
                )
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val documentFile = DocumentFile.fromTreeUri(this, treeUri)

                if (documentFile?.exists() == false || documentFile == null) {
                    throw NoSuchFileException(File(treeUri.toString()))
                }

                val file =
                    documentFile.createFile(saveTarget.imageFormat.type, saveTarget.filename!!)

                val imageUri = file!!.uri
                SavingFolder(
                    outputStream = contentResolver.openOutputStream(imageUri),
                    fileUri = imageUri
                )
            } else {
                val path = treeUri.toPath(this@getSavingFolder)?.split("/")?.let {
                    it - it.last() to it.last()
                }
                val imagesDir = File(
                    Environment.getExternalStoragePublicDirectory(
                        "${path?.first?.joinToString("/")}"
                    ), path?.second.toString()
                )
                if (!imagesDir.exists()) imagesDir.mkdir()
                SavingFolder(
                    outputStream = FileOutputStream(File(imagesDir, saveTarget.filename!!)),
                    fileUri = File(imagesDir, saveTarget.filename!!).toUri()
                )
            }
        }
    }

    private fun Context.findActivity(): Activity? = when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> null
    }

    private fun Uri.toPath(
        context: Context,
        isTreeUri: Boolean = true
    ): String? {
        return if (isTreeUri) {
            DocumentFile.fromTreeUri(context, this)
        } else {
            DocumentFile.fromSingleUri(context, this)
        }?.uri?.path?.split(":")?.lastOrNull()
    }

    private fun Context.getFileName(uri: Uri): String? = DocumentFile.fromSingleUri(this, uri)?.name

}