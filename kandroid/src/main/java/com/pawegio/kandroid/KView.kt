package com.pawegio.kandroid

import android.view.View

/**
 * @author pawegio
 */
@Suppress("UNCHECKED_CAST")
public fun View.find<T : View>(id: Int): T = findViewById(id) as T