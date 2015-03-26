package com.pawegio.kandroid

import android.content.Context
import android.content.Intent

/**
 * @author pawegio
 */
public inline fun Intent<reified T>(context: Context): Intent = Intent(context, javaClass<T>())