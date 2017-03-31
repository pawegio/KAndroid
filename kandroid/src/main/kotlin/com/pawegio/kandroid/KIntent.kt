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

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Patterns

inline fun <reified T : Any> IntentFor(context: Context): Intent = Intent(context, T::class.java)

inline fun Intent.start(context: Context) = context.startActivity(this)

inline fun Intent.startForResult(activity: Activity, requestCode: Int) = activity.startActivityForResult(this, requestCode)

inline fun Intent.startForResult(fragment: Fragment, requestCode: Int) = fragment.startActivityForResult(this, requestCode)

inline fun WebIntent(url: String): Intent =
        if (Patterns.WEB_URL.matcher(url).matches()) {
            Intent(Intent.ACTION_VIEW, Uri.parse(url))
        } else {
            throw IllegalArgumentException("Passed url: $url does not match URL pattern.")
        }