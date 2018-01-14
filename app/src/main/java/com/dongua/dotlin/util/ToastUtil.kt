package com.dongua.dotlin.util

import android.content.Context
import android.widget.Toast

/**
 * author: Lewis
 * data: On 18-1-13.
 */
class ToastUtil(var context: Context) {
    fun longToast(content: String) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show()
    }

    fun shortToast(content: String) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun longToast(context: Context, content: String) {
            Toast.makeText(context, content, Toast.LENGTH_LONG).show()
        }

        fun shortToast(context: Context, content: String) {
            Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
        }
    }

}