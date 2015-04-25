package com.pawegio.kandroid

import android.app.Activity
import android.app.Fragment
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.widget.Toast
import android.support.v4.app.Fragment as SupportFragment

/**
 * @author pawegio
 */
suppress("UNCHECKED_CAST")
public fun Fragment.getActivity<T : Activity>(): T = getActivity() as T

public fun Fragment.getDefaultSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity())

public fun Fragment.toast(text: CharSequence): Unit = getActivity().toast(text)

public fun Fragment.longToast(text: CharSequence): Unit = getActivity().longToast(text)

suppress("UNCHECKED_CAST")
public fun SupportFragment.getActivity<T : Activity>(): T = getActivity() as T

public fun SupportFragment.getDefaultSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity())

public fun SupportFragment.toast(text: CharSequence): Unit = getActivity().toast(text)

public fun SupportFragment.longToast(text: CharSequence): Unit = getActivity().longToast(text)