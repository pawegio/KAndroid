package com.pawegio.kandroid

import android.os.Handler
import android.os.Looper

/**
 * @author pawegio
 */
fun runAsync(action: () -> Unit) {
    Thread(Runnable(action)).start()
}

fun runOnUiThread(action: () -> Unit) {
    Handler(Looper.getMainLooper()).post(Runnable(action))
}

fun runDelayed(delayMillis: Long, action: () -> Unit) {
    Handler().postDelayed(Runnable(action), delayMillis)
}

fun runDelayedOnUiThread(delayMillis: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)
}