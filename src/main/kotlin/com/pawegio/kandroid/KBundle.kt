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

inline fun <reified T : Parcelable> Bundle.putParcelableCollection(key: String, value: Collection<T>) = putParcelableArray(key, value.toTypedArray())

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Parcelable> Bundle.getParcelableMutableList(key: String): MutableList<T> = (getParcelableArray(key) as Array<T>).toMutableList()

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Parcelable> Bundle.getParcelableMutableSet(key: String): MutableSet<T> = (getParcelableArray(key) as Array<T>).toMutableSet()