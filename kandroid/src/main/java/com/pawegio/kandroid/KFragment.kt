package com.pawegio.kandroid

import android.app.Fragment
import android.preference.PreferenceManager
import android.support.v4.app.Fragment as SupportFragment

/**
 * @author pawegio
 */
fun Fragment.getDefaultSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(activity)

fun Fragment.toast(text: CharSequence) = activity.toast(text)

fun Fragment.longToast(text: CharSequence) = activity.longToast(text)

fun SupportFragment.getDefaultSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(activity)

fun SupportFragment.toast(text: CharSequence) = activity.toast(text)

fun SupportFragment.longToast(text: CharSequence) = activity.longToast(text)