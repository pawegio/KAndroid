package com.pawegio.kandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author pawegio
 */
public fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View
        = LayoutInflater.from(this).inflate(layoutResId, parent, attachToRoot)