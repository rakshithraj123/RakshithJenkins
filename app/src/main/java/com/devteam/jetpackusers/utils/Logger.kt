package com.devteam.jetpackusers.utils

import android.os.Build
import android.util.Log

/**
 * Logger utility class. If the DEBUG flag is false, then it does not log the msg
 *
 */
object Logger {
    private const val TAG: String = "App"
    private const val DEBUG = true

    // general purpose debuggable log method
    fun d(msg: String) {
        log("**** -> $msg")
    }

    // logs thread detail
    fun logThreadDetails(from: String) {
        log(
            "*** $from  --> Thread # ${Thread.currentThread().id} with " +
                    "name = ${Thread.currentThread().name}"
        )
    }

    // this is a special method to log the msg without the influence of DEBUG flag
    fun logCritical(msg: String) {
        Log.d(TAG, msg)
    }

    private fun log(msg: String) {
        if (DEBUG) Log.d(TAG, msg)
    }

    private fun testMethod() {
        // Added by KP
        // Testing the webhook
    }
}