package ru.tech.imageresizershrinker.presentation.limits_resize_screen.viewModel


import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.exifinterface.media.ExifInterface
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.tech.imageresizershrinker.domain.image.ImageManager
import ru.tech.imageresizershrinker.domain.model.ImageData
import ru.tech.imageresizershrinker.domain.model.ImageFormat
import ru.tech.imageresizershrinker.domain.model.ImageInfo
import ru.tech.imageresizershrinker.domain.model.ResizeType
import ru.tech.imageresizershrinker.domain.saving.FileController
import ru.tech.imageresizershrinker.domain.saving.model.ImageSaveTarget
import javax.inject.Inject

@HiltViewModel
class LimitsResizeViewModel @Inject constructor(
    private val fileController: FileController,
    private val imageManager: ImageManager<Bitmap, ExifInterface>
) : ViewModel() {

    private val _canSave = mutableStateOf(false)
    val canSave by _canSave

    private val _uris = mutableStateOf<List<Uri>?>(null)
    val uris by _uris

    private val _bitmap: MutableState<Bitmap?> = mutableStateOf(null)
    val bitmap: Bitmap? by _bitmap

    private val _keepExif = mutableStateOf(false)
    val keepExif by _keepExif

    private val _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: Boolean by _isLoading

    private val _previewBitmap: MutableState<Bitmap?> = mutableStateOf(null)
    val previewBitmap: Bitmap? by _previewBitmap

    private val _done: MutableState<Int> = mutableIntStateOf(0)
    val done by _done

    private val _selectedUri: MutableState<Uri?> = mutableStateOf(null)
    val selectedUri by _selectedUri

    private val _imageInfo = mutableStateOf(ImageInfo(resizeType = ResizeType.Limits.Copy))
    val imageInfo by _imageInfo

    fun setMime(imageFormat: ImageFormat) {
        _imageInfo.value = _imageInfo.value.copy(imageFormat = imageFormat)
    }

    fun updateUris(uris: List<Uri>?) {
        _uris.value = null
        _uris.value = uris
        _selectedUri.value = uris?.firstOrNull()
    }

    fun updateUrisSilently(removedUri: Uri) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _uris.value = uris
                if (_selectedUri.value == removedUri) {
                    val index = uris?.indexOf(removedUri) ?: -1
                    if (index == 0) {
                        uris?.getOrNull(1)?.let {
                            _selectedUri.value = it
                            _bitmap.value = imageManager.getImage(it.toString())?.image
                        }
                    } else {
                        uris?.getOrNull(index - 1)?.let {
                            _selectedUri.value = it
                            _bitmap.value = imageManager.getImage(it.toString())?.image
                        }
                    }
                }
                val u = _uris.value?.toMutableList()?.apply {
                    remove(removedUri)
                }
                _uris.value = u
            }
        }
    }

    fun updateBitmap(bitmap: Bitmap?, preview: Bitmap? = null) {
        viewModelScope.launch {
            _isLoading.value = true
            _bitmap.value = imageManager.scaleUntilCanShow(bitmap)
            _previewBitmap.value = preview ?: _bitmap.value
            _isLoading.value = false
        }
    }

    fun setKeepExif(boolean: Boolean) {
        _keepExif.value = boolean
    }

    fun saveBitmaps(
        onResult: (Int, String) -> Unit
    ) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            var failed = 0
            if (!fileController.isExternalStorageWritable()) {
                onResult(-1, "")
                fileController.requestReadWritePermissions()
            } else {
                _done.value = 0
                uris?.forEach { uri ->
                    runCatching {
                        imageManager.getImage(uri.toString())?.image
                    }.getOrNull()?.let { bitmap ->
                        imageManager.resize(
                            image = bitmap,
                            width = imageInfo.width,
                            height = imageInfo.height,
                            resizeType = imageInfo.resizeType
                        )
                    }?.let { localBitmap ->
                        fileController.save(
                            ImageSaveTarget<ExifInterface>(
                                imageInfo = imageInfo.copy(
                                    width = localBitmap.width,
                                    height = localBitmap.height
                                ),
                                originalUri = uri.toString(),
                                sequenceNumber = _done.value + 1,
                                data = imageManager.compress(
                                    ImageData(
                                        image = localBitmap,
                                        imageInfo = imageInfo.copy(
                                            width = localBitmap.width,
                                            height = localBitmap.height
                                        )
                                    )
                                )
                            ), keepMetadata = keepExif
                        )
                    } ?: {
                        failed += 1
                    }

                    _done.value += 1
                }
                onResult(failed, fileController.savingPath)
            }
        }
    }

    fun setBitmap(uri: Uri) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _isLoading.value = true
                updateBitmap(imageManager.getImage(uri.toString())?.image)
                _selectedUri.value = uri
                _isLoading.value = false
            }
        }
    }


    private fun updateCanSave() {
        _canSave.value =
            _bitmap.value != null && (_imageInfo.value.height != 0 && _imageInfo.value.width != 0)
    }

    fun updateWidth(i: Int) {
        _imageInfo.value = _imageInfo.value.copy(width = i)
        updateCanSave()
    }

    fun updateHeight(i: Int) {
        _imageInfo.value = _imageInfo.value.copy(height = i)
        updateCanSave()
    }

    fun shareBitmaps(onComplete: () -> Unit) {
        viewModelScope.launch {
            imageManager.shareImages(
                uris = uris?.map { it.toString() } ?: emptyList(),
                imageLoader = { uri ->
                    imageManager.getImage(uri)?.image?.let { bitmap: Bitmap ->
                        imageManager.resize(
                            bitmap,
                            imageInfo.width,
                            imageInfo.height,
                            imageInfo.resizeType
                        )
                    }?.let {
                        ImageData(
                            it, imageInfo.copy(
                                width = it.width,
                                height = it.height
                            )
                        )
                    }
                },
                onProgressChange = {
                    if (it == -1) {
                        onComplete()
                        _done.value = 0
                    } else {
                        _done.value = it
                    }
                }
            )
        }
    }

    fun decodeBitmapFromUri(uri: Uri, onError: (Throwable) -> Unit) {
        viewModelScope.launch {
            imageManager.getImageAsync(
                uri = uri.toString(),
                originalSize = true,
                onGetImage = {
                    updateBitmap(it.image)
                    setMime(it.imageInfo.imageFormat)
                },
                onError = onError
            )
        }
    }

    fun getImageManager(): ImageManager<Bitmap, ExifInterface> = imageManager

    fun setQuality(fl: Float) {
        _imageInfo.value = _imageInfo.value.copy(quality = fl.coerceIn(0f, 100f))
    }

    fun setResizeType(resizeType: ResizeType) {
        _imageInfo.value = _imageInfo.value.copy(resizeType = resizeType)
    }

}