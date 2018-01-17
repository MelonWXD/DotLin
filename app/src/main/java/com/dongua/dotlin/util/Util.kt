package com.dongua.dotlin.util

import android.content.Context
import android.os.Build
import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.*

/**
 * author: Lewis
 * data: On 18-1-15.
 */
//检测MIUI
private val KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code"
private val KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name"
private val KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage"

fun isMIUI(): Boolean {
    val device = Build.MANUFACTURER

    if (device == "Xiaomi") {
        val prop = Properties()
        try {
            prop.load(FileInputStream(File(Environment.getRootDirectory(), "build.prop")))
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }

        return (prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null
                || prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null
                || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null)
    } else {
        return false
    }
}

fun getStatusBarHeight(context: Context): Int {
    var result = 0
    val resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
            "android")
    if (resourceId > 0) {
        result = context.getResources().getDimensionPixelSize(resourceId)
    }
    return result
}
