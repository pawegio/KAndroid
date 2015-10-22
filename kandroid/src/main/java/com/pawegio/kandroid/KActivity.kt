package com.pawegio.kandroid

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast

/**
 * @author pawegio
 */
@Suppress("UNCHECKED_CAST")
fun <T : View> Activity.find(id: Int): T = findViewById(id) as T

fun Activity.toast(text: CharSequence): Unit = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

fun Activity.longToast(text: CharSequence): Unit = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

inline fun <reified T : Any> Activity.startActivityForResult(requestCode: Int, options: Bundle? = null) {
    startActivityForResult(IntentFor<T>(this), requestCode, options)
}