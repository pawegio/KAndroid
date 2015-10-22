package com.pawegio.kandroid

import android.view.View

/**
 * @author pawegio
 */
@Suppress("UNCHECKED_CAST")
fun <T : View> View.find(id: Int): T = findViewById(id) as T