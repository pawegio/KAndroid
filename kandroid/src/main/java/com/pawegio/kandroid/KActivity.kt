package com.pawegio.kandroid

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast

/**
 * @author pawegio
 */
@Suppress("UNCHECKED_CAST")
public fun Activity.find<T : View>(id: Int): T = findViewById(id) as T

public fun Activity.toast(text: CharSequence): Unit = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

public fun Activity.longToast(text: CharSequence): Unit = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

public inline fun Activity.startActivityForResult<reified T : Any>(requestCode: Int, options: Bundle? = null) {
    startActivityForResult(IntentFor<T>(this), requestCode, options)
}