package com.pawegio.kandroid

import android.app.Fragment
import android.preference.PreferenceManager
import android.support.v4.app.Fragment as SupportFragment

/**
 * @author pawegio
 */
public fun Fragment.getDefaultSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(activity)

public fun Fragment.toast(text: CharSequence) = activity.toast(text)

public fun Fragment.longToast(text: CharSequence) = activity.longToast(text)

public fun SupportFragment.getDefaultSharedPreferences() = PreferenceManager.getDefaultSharedPreferences(activity)

public fun SupportFragment.toast(text: CharSequence) = activity.toast(text)

public fun SupportFragment.longToast(text: CharSequence) = activity.longToast(text)