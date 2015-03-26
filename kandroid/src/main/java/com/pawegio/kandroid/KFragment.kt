package com.pawegio.kandroid

import android.app.Fragment
import android.widget.Toast
import android.support.v4.app.Fragment as SupportFragment

/**
 * @author pawegio
 */
public fun Fragment.longToast(text: CharSequence): Unit = Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show()

public fun Fragment.shortToast(text: CharSequence): Unit = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show()

public fun SupportFragment.longToast(text: CharSequence): Unit = Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show()

public fun SupportFragment.shortToast(text: CharSequence): Unit = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show()