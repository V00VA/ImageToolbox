package ru.tech.imageresizershrinker.presentation.root.utils.exception

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import ru.tech.imageresizershrinker.presentation.root.widget.activity.M3Activity
import kotlin.system.exitProcess


class GlobalExceptionHandler<T : CrashHandler> private constructor(
    private val applicationContext: Context,
    private val defaultHandler: Thread.UncaughtExceptionHandler,
    private val activityToBeLaunched: Class<T>
) : Thread.UncaughtExceptionHandler {

    override fun uncaughtException(p0: Thread, p1: Throwable) {
        kotlin.runCatching {
            Log.e(this.toString(), p1.stackTraceToString())
            applicationContext.launchActivity(activityToBeLaunched, p1)
            exitProcess(0)
        }.getOrElse {
            defaultHandler.uncaughtException(p0, p1)
        }
    }

    private fun <T : Activity> Context.launchActivity(
        activity: Class<T>,
        exception: Throwable
    ) {
        val crashedIntent = Intent(applicationContext, activity).apply {
            putExtra(
                INTENT_DATA_NAME,
                "${exception::class.java.simpleName}\n\n${Log.getStackTraceString(exception)}"
            )
            addFlags(defFlags)
        }
        applicationContext.startActivity(crashedIntent)
    }

    companion object {
        fun <T : CrashHandler> initialize(
            applicationContext: Context,
            activityToBeLaunched: Class<T>
        ) = Thread.setDefaultUncaughtExceptionHandler(
            GlobalExceptionHandler(
                applicationContext,
                Thread.getDefaultUncaughtExceptionHandler() as Thread.UncaughtExceptionHandler,
                activityToBeLaunched
            )
        )
    }
}

private const val INTENT_DATA_NAME = "GlobalExceptionHandler"
private const val defFlags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
        Intent.FLAG_ACTIVITY_NEW_TASK or
        Intent.FLAG_ACTIVITY_CLEAR_TASK

abstract class CrashHandler : M3Activity() {
    fun getCrashReason(): String = intent.getStringExtra(INTENT_DATA_NAME) ?: ""
}