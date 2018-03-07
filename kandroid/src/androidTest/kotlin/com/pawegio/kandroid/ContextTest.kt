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

import android.support.test.annotation.UiThreadTest
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import com.pawegio.kandroid.test.R

@RunWith(AndroidJUnit4::class)
class ContextTest {

    @Test
    @UiThreadTest
    fun shortToastTest() {
        val toast = context.toast("Hello short toast")
        assertEquals(View.VISIBLE, toast.view.visibility)
        assertEquals(Toast.LENGTH_SHORT, toast.duration)
        assertEquals("Hello short toast", getToastText(toast))
    }

    @Test
    @UiThreadTest
    fun shortToastWithResTest() {
        val text = context.getString(R.string.toast_test_text)
        val toast = context.toast(text)
        assertEquals(View.VISIBLE, toast.view.visibility)
        assertEquals(Toast.LENGTH_SHORT, toast.duration)
        assertEquals(text, getToastText(toast))
    }

    @Test
    @UiThreadTest
    fun longToastTest() {
        val toast = context.longToast("Hello long toast")
        assertEquals(View.VISIBLE, toast.view.visibility)
        assertEquals(Toast.LENGTH_LONG, toast.duration)
        assertEquals("Hello long toast", getToastText(toast))
    }

    @Test
    @UiThreadTest
    fun longToastTestWithResTest() {
        val text = context.getString(R.string.toast_long_test_text)
        val toast = context.longToast(text)
        assertEquals(View.VISIBLE, toast.view.visibility)
        assertEquals(Toast.LENGTH_LONG, toast.duration)
        assertEquals(text, getToastText(toast))
    }

    private fun getToastText(toast: Toast): String {
        for (view in (toast.view as ViewGroup).views) {
            if (view is TextView)
                return view.text.toString()
        }
        return ""
    }
}