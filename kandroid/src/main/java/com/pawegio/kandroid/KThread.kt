package com.pawegio.kandroid

/**
 * @author pawegio
 */
[suppress("UNCHECKED_CAST")]
public fun runAsync(action: () -> Unit): Unit = Thread(Runnable(action)).start()