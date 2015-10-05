package com.pawegio.kandroid

import android.content.Context
import android.content.Intent

/**
 * @author pawegio
 */
inline fun IntentFor<reified T : Any>(context: Context): Intent = Intent(context, T::class.java)