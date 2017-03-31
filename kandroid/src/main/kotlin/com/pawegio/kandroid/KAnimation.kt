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

package com.pawegio.kandroid

import android.content.Context
import android.support.annotation.AnimRes
import android.view.animation.Animation
import android.view.animation.AnimationUtils

@Suppress("NOTHING_TO_INLINE")
inline fun Context.loadAnimation(@AnimRes id: Int) = AnimationUtils.loadAnimation(applicationContext, id)

inline fun Animation.animListener(init: AnimListener.() -> Unit) = setAnimationListener(AnimListener().apply(init))

class AnimListener : Animation.AnimationListener {

    private var _onAnimationRepeat: ((Animation?) -> Unit)? = null
    private var _onAnimationEnd: ((Animation?) -> Unit)? = null
    private var _onAnimationStart: ((Animation?) -> Unit)? = null

    override fun onAnimationRepeat(animation: Animation?) {
        _onAnimationRepeat?.invoke(animation)
    }

    override fun onAnimationEnd(animation: Animation?) {
        _onAnimationEnd?.invoke(animation)
    }

    override fun onAnimationStart(animation: Animation?) {
        _onAnimationStart?.invoke(animation)
    }

    fun onAnimationRepeat(listener: (Animation?) -> Unit) {
        _onAnimationRepeat = listener
    }

    fun onAnimationEnd(listener: (Animation?) -> Unit) {
        _onAnimationEnd = listener
    }

    fun onAnimationStart(listener: (Animation?) -> Unit) {
        _onAnimationStart = listener
    }
}