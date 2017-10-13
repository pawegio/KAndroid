/*
 * Copyright 2017 Hadi Satrio
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

import android.animation.Animator

inline fun Animator.animListener(init: AnimatorListener.() -> Unit) = addListener(AnimatorListener().apply(init))

class AnimatorListener : Animator.AnimatorListener {

    private var _onAnimationRepeat: ((Animator?) -> Unit)? = null
    private var _onAnimationEnd: ((Animator?) -> Unit)? = null
    private var _onAnimationStart: ((Animator?) -> Unit)? = null
    private var _onAnimationCancel: ((Animator?) -> Unit)? = null

    override fun onAnimationRepeat(animator: Animator?) {
        _onAnimationRepeat?.invoke(animator)
    }

    override fun onAnimationEnd(animator: Animator?) {
        _onAnimationEnd?.invoke(animator)
    }

    override fun onAnimationStart(animator: Animator?) {
        _onAnimationStart?.invoke(animator)
    }

    override fun onAnimationCancel(animator: Animator?) {
        _onAnimationCancel?.invoke(animator)
    }

    fun onAnimationRepeat(listener: (Animator?) -> Unit) {
        _onAnimationRepeat = listener
    }

    fun onAnimationEnd(listener: (Animator?) -> Unit) {
        _onAnimationEnd = listener
    }

    fun onAnimationStart(listener: (Animator?) -> Unit) {
        _onAnimationStart = listener
    }

    fun onAnimationCancel(listener: (Animator?) -> Unit) {
        _onAnimationCancel = listener
    }
}