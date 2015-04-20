package com.pawegio.kandroid

import android.util.Log

/**
 * @author pawegio
 */
public fun Any.v(tag: String, msg: String) {
    Log.v(tag, msg)
}

public fun Any.d(tag: String, msg: String) {
    Log.d(tag, msg)
}

public fun Any.i(tag: String, msg: String) {
    Log.i(tag, msg)
}

public fun Any.w(tag: String, msg: String) {
    Log.w(tag, msg)
}

public fun Any.e(tag: String, msg: String) {
    Log.e(tag, msg)
}

public fun Any.wtf(tag: String, msg: String) {
    Log.wtf(tag, msg)
}

public fun Any.v(msg: String) {
    Log.v(getTag(), msg)
}

public fun Any.d(msg: String) {
    Log.d(getTag(), msg)
}

public fun Any.i(msg: String) {
    Log.i(getTag(), msg)
}

public fun Any.w(msg: String) {
    Log.w(getTag(), msg)
}

public fun Any.e(msg: String) {
    Log.e(getTag(), msg)
}

public fun Any.wtf(msg: String) {
    Log.wtf(getTag(), msg)
}

private fun Any.getTag() = javaClass.getSimpleName()