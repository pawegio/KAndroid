package com.pawegio.kandroid

import android.widget.SeekBar

/**
 * @author pawegio
 */
public fun SeekBar.onProgressChanged(callback: (Int, Boolean) -> Unit) {
    setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onStopTrackingTouch(seekBar: SeekBar) {

        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            callback(progress, fromUser)
        }
    })
}