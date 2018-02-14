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

import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class KViewTest {

    private val view = View(context)

    init {
        view.layoutParams = ViewGroup.LayoutParams(10, 10)
    }

    @Test
    fun visibleTest() {
        view.visible = false
        assertFalse(view.visible)
        assertEquals(View.GONE, view.visibility)

        view.visible = true
        assertTrue(view.visible)
        assertEquals(View.VISIBLE, view.visibility)
    }

    @Test
    fun showHideTest() {
        view.hide()
        assertFalse(view.visible)
        assertEquals(View.GONE, view.visibility)

        view.show()
        assertTrue(view.visible)
        assertEquals(View.VISIBLE, view.visibility)

        view.hide(false)
        assertFalse(view.visible)
        assertEquals(View.INVISIBLE, view.visibility)
    }

    @Test
    fun setWidthTest() {
        view.setWidth(20)
        assertEquals(20, view.layoutParams.width)
    }

    @Test
    fun setHeightTest() {
        view.setHeight(30)
        assertEquals(30, view.layoutParams.height)
    }

    @Test
    fun setSizeTest() {
        view.setSize(40, 50)
        assertEquals(40, view.layoutParams.width)
        assertEquals(50, view.layoutParams.height)
    }
}
