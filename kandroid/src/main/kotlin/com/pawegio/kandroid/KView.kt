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

@file:Suppress("NOTHING_TO_INLINE")

package com.pawegio.kandroid

import android.support.annotation.IdRes
import android.view.View
import android.view.View.*

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id) as T

var View.visible
    get() = visibility == VISIBLE
    set(value) {
        visibility = if (value) VISIBLE else GONE
    }

inline fun View.hide(gone: Boolean = true) {
    visibility = if (gone) GONE else INVISIBLE
}

inline fun View.show() {
    visibility = VISIBLE
}

inline fun View.setWidth(width: Int) {
    val params = layoutParams
    params.width = width
    layoutParams = params
}

inline fun View.setHeight(height: Int) {
    val params = layoutParams
    params.height = height
    layoutParams = params
}

inline fun View.setSize(width:Int, height:Int) {
    val params = layoutParams
    params.width = width
    params.height = height
    layoutParams = params
}