package com.pawegio.kandroid

import android.os.Handler
import android.os.Looper

/**
 * @author pawegio
 */
public fun runAsync(action: () -> Unit) {
    Thread(Runnable(action)).start()
}

public fun runOnUiThread(action: () -> Unit) {
    Handler(Looper.getMainLooper()).post(Runnable(action))
}

public fun runDelayed(delayMillis: Long, action: () -> Unit) {
    Handler().postDelayed(Runnable(action), delayMillis)
}

public fun runDelayedOnUiThread(delayMillis: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)
}