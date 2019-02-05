package com.wenhao.swoosh.Utilities

import android.content.Context
import android.widget.Toast
import android.widget.ToggleButton

fun getState(btn: ToggleButton): String{
    return if (btn.isChecked) {
        btn.text.toString()
    }else{
        ""
    }
}