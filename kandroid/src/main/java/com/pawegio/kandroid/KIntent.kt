package com.pawegio.kandroid

import android.content.Context
import android.content.Intent

/**
 * @author pawegio
 */
inline fun <reified T : Any> IntentFor(context: Context): Intent = Intent(context, T::class.java)