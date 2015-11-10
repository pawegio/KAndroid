package com.pawegio.kandroid

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

/**
 * @author pawegio
 */
fun TextView.textWatcher(init: _TextWatcher.() -> Unit) {
    addTextChangedListener(_TextWatcher().apply(init))
}

class _TextWatcher : TextWatcher {

    private var _beforeTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var _onTextChanged: ((CharSequence?, Int, Int, Int) -> Unit)? = null
    private var _afterTextChanged: ((Editable?) -> Unit)? = null

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        _beforeTextChanged?.invoke(s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        _onTextChanged?.invoke(s, start, before, count)
    }

    override fun afterTextChanged(s: Editable?) {
        _afterTextChanged?.invoke(s)
    }

    public fun beforeTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _beforeTextChanged = listener
    }

    public fun onTextChanged(listener: (CharSequence?, Int, Int, Int) -> Unit) {
        _onTextChanged = listener
    }

    public fun afterTextChanged(listener: (Editable?) -> Unit) {
        _afterTextChanged = listener
    }

}