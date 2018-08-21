/*
 * Copyright 2015-2016 Paweł Gajda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("DeprecatedCallableAddReplaceWith")

package com.pawegio.kandroid

import android.app.Fragment
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v7.app.AlertDialog
import android.view.KeyEvent
import android.view.View
import android.widget.ListAdapter

@Deprecated("android.app.Fragment is Deprecated")
fun Fragment.alert(
        message: String,
        title: String? = null,
        init: (KAlertDialogBuilder.() -> Unit)? = null
) = activity.alert(message, title, init)

fun Context.alert(
        message: String,
        title: String? = null,
        init: (KAlertDialogBuilder.() -> Unit)? = null
) = KAlertDialogBuilder(this).apply {
    if (title != null) title(title)
    message(message)
    if (init != null) init()
}

@Deprecated("android.app.Fragment is Deprecated")
fun Fragment.alert(
        @StringRes message: Int,
        @StringRes title: Int? = null,
        init: (KAlertDialogBuilder.() -> Unit)? = null
) = activity.alert(message, title, init)

fun Context.alert(
        @StringRes message: Int,
        @StringRes title: Int? = null,
        init: (KAlertDialogBuilder.() -> Unit)? = null
) = KAlertDialogBuilder(this).apply {
    if (title != null) title(title)
    message(message)
    if (init != null) init()
}

@Deprecated("android.app.Fragment is Deprecated")
fun Fragment.alert(init: KAlertDialogBuilder.() -> Unit): KAlertDialogBuilder = activity.alert(init)

fun Context.alert(init: KAlertDialogBuilder.() -> Unit) = KAlertDialogBuilder(this).apply { init() }

@Deprecated("android.app.Fragment and android.app.ProgressDialog are Deprecated")
fun Fragment.progressDialog(
        @StringRes message: Int? = null,
        @StringRes title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = activity.progressDialog(message, title, init)

@Deprecated("android.app.ProgressDialog is Deprecated")
fun Context.progressDialog(
        @StringRes message: Int? = null,
        @StringRes title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(false, message?.let { getString(it) }, title?.let { getString(it) }, init)

@Deprecated("android.app.Fragment and android.app.ProgressDialog are Deprecated")
fun Fragment.indeterminateProgressDialog(
        @StringRes message: Int? = null,
        @StringRes title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = activity.progressDialog(message, title, init)

@Deprecated("android.app.ProgressDialog is Deprecated")
fun Context.indeterminateProgressDialog(
        @StringRes message: Int? = null,
        @StringRes title: Int? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(true, message?.let { getString(it) }, title?.let { getString(it) }, init)

@Deprecated("android.app.Fragment and android.app.ProgressDialog are Deprecated")
fun Fragment.progressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = activity.progressDialog(message, title, init)

@Deprecated("android.app.ProgressDialog is Deprecated")
fun Context.progressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(false, message, title, init)

@Deprecated("android.app.Fragment and android.app.ProgressDialog are Deprecated")
fun Fragment.indeterminateProgressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = activity.indeterminateProgressDialog(message, title, init)

@Deprecated("android.app.ProgressDialog is Deprecated")
fun Context.indeterminateProgressDialog(
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(true, message, title, init)

@Deprecated("android.app.ProgressDialog is Deprecated")
private fun Context.progressDialog(
        indeterminate: Boolean,
        message: String? = null,
        title: String? = null,
        init: (ProgressDialog.() -> Unit)? = null
) = ProgressDialog(this).apply {
    isIndeterminate = indeterminate
    if (!indeterminate) setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
    if (message != null) setMessage(message)
    if (title != null) setTitle(title)
    if (init != null) init()
    show()
}

@Deprecated("android.app.Fragment is Deprecated")
fun Fragment.selector(
        title: CharSequence? = null,
        items: List<CharSequence>,
        onClick: (Int) -> Unit
) = activity.selector(title, items, onClick)

fun Context.selector(
        title: CharSequence? = null,
        items: List<CharSequence>,
        onClick: (Int) -> Unit
) {
    with(KAlertDialogBuilder(this)) {
        if (title != null) title(title)
        items(items, onClick)
        show()
    }
}

class KAlertDialogBuilder(val ctx: Context) {

    val builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
    var dialog: AlertDialog? = null

    fun dismiss() = dialog?.dismiss()

    fun show(): KAlertDialogBuilder {
        dialog = builder.create()
        dialog!!.show()
        return this
    }

    fun title(title: CharSequence) {
        builder.setTitle(title)
    }

    fun title(@StringRes resource: Int) {
        builder.setTitle(resource)
    }

    fun message(title: CharSequence) {
        builder.setMessage(title)
    }

    fun message(@StringRes resource: Int) {
        builder.setMessage(resource)
    }

    fun icon(@DrawableRes icon: Int) {
        builder.setIcon(icon)
    }

    fun icon(icon: Drawable) {
        builder.setIcon(icon)
    }

    fun customTitle(title: View) {
        builder.setCustomTitle(title)
    }

    fun customView(view: View) {
        builder.setView(view)
    }

    fun cancellable(value: Boolean = true) {
        builder.setCancelable(value)
    }

    fun onCancel(f: () -> Unit) {
        builder.setOnCancelListener { f() }
    }

    fun onKey(f: (keyCode: Int, e: KeyEvent) -> Boolean) {
        builder.setOnKeyListener({ _, keyCode, event -> f(keyCode, event) })
    }

    fun neutralButton(@StringRes textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit = { dismiss() }) {
        neutralButton(ctx.getString(textResource), f)
    }

    fun neutralButton(title: String, f: DialogInterface.() -> Unit = { dismiss() }) {
        builder.setNeutralButton(title, { dialog, _ -> dialog.f() })
    }

    fun positiveButton(@StringRes textResource: Int = android.R.string.ok, f: DialogInterface.() -> Unit) {
        positiveButton(ctx.getString(textResource), f)
    }

    fun positiveButton(title: String, f: DialogInterface.() -> Unit) {
        builder.setPositiveButton(title, { dialog, _ -> dialog.f() })
    }

    fun negativeButton(@StringRes textResource: Int = android.R.string.cancel, f: DialogInterface.() -> Unit = { dismiss() }) {
        negativeButton(ctx.getString(textResource), f)
    }

    fun negativeButton(title: String, f: DialogInterface.() -> Unit = { dismiss() }) {
        builder.setNegativeButton(title, { dialog, _ -> dialog.f() })
    }

    fun items(@ArrayRes itemsId: Int, f: (which: Int) -> Unit) {
        items(ctx.resources!!.getTextArray(itemsId), f)
    }

    fun items(items: List<CharSequence>, f: (which: Int) -> Unit) {
        items(items.toTypedArray(), f)
    }

    fun items(items: Array<CharSequence>, f: (which: Int) -> Unit) {
        builder.setItems(items, { _, which -> f(which) })
    }

    fun adapter(adapter: ListAdapter, f: (which: Int) -> Unit) {
        builder.setAdapter(adapter, { _, which -> f(which) })
    }

    fun adapter(cursor: Cursor, labelColumn: String, f: (which: Int) -> Unit) {
        builder.setCursor(cursor, { _, which -> f(which) }, labelColumn)
    }
}