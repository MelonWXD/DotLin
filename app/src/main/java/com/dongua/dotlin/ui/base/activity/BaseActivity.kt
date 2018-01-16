package com.dongua.dotlin.ui.base.activity

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.dongua.dotlin.util.isMIUI


/**
 * author: Lewis
 * data: On 18-1-15.
 */
abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        setTranslucentStatus()
        initBundle(savedInstanceState)
        initWidget()
        initData()


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveBundle(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    protected open fun initBundle(savedInstanceState: Bundle?) {}
    protected open fun saveBundle(outState: Bundle){}

//     replace with member
//    protected abstract fun getLayoutID(): Int
    protected abstract fun initWidget()
    protected abstract fun initData()


    private fun setTranslucentStatus() {
        val win = window
        val winParams = win.attributes
        val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        winParams.flags = winParams.flags or bits
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //字体反转到深色
            win.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        if (isMIUI()) {
            MIUISetStatusBarLightMode(win, true)
        }
        win.attributes = winParams
    }


    fun MIUISetStatusBarLightMode(window: Window?, dark: Boolean): Boolean {
        var result = false
        if (window != null) {
            val clazz = window.javaClass
            try {
                var darkModeFlag = 0
                val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
                val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
                darkModeFlag = field.getInt(layoutParams)
                val extraFlagField = clazz.getMethod("setExtraFlags", Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag)//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag)//清除黑色字体
                }
                result = true
            } catch (e: Exception) {

            }

        }
        return result
    }
}