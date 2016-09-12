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

import android.os.Bundle
import android.os.Parcelable

inline fun <reified T : Parcelable> Bundle.putParcelableCollection(key: String, value: Collection<T>) =
        putParcelableArray(key, value.toTypedArray())

inline fun Bundle.getParcelableMutableList(key: String): MutableList<Parcelable> = getParcelableArray(key).toMutableList()

inline fun Bundle.getParcelableMutableSet(key: String): MutableSet<Parcelable> = getParcelableArray(key).toMutableSet()