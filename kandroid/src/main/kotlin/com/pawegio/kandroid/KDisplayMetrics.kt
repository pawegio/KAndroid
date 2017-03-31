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

import android.app.Fragment
import android.support.v4.app.Fragment as SupportFragment
import android.content.Context
import android.view.View

inline fun Context.dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

inline fun Context.sp(value: Int): Int = (value * resources.displayMetrics.scaledDensity).toInt()

inline fun Fragment.dp(value: Int): Int = activity.dp(value)

inline fun Fragment.sp(value: Int): Int = activity.sp(value)

inline fun SupportFragment.dp(value: Int): Int = activity.dp(value)

inline fun SupportFragment.sp(value: Int): Int = activity.sp(value)

inline fun View.dp(value: Int): Int = context.dp(value)

inline fun View.sp(value: Int): Int = context.sp(value)