package com.dongua.dotlin.ui.base.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.dongua.dotlin.R

/**
 * author: Lewis
 * data: On 18-1-10.
 */
abstract class BaseToolBarActivity : BaseActivity() {


    //    private var mToolBarLayout: LinearLayout? = null
//    private var mToolBar: RelativeLayout? = null
//    private var mRootView: LinearLayout? = null
//    private var mContentView: View? = null

    lateinit var mToolBarLayout: LinearLayout
    lateinit var mToolBar: RelativeLayout
    //实际根布局
    lateinit var mRootView: LinearLayout
    //子类Activity布局
    lateinit var mContentView: View


    /**
     * 根据子类传入的布局ID来获取View，在该View外面增加一个LL和ToolBar再setContentView
     * @param layoutResID 子类重写BaseActivity的getLayoutID
     */
    override fun setContentView(layoutResID: Int) {
        mContentView = LayoutInflater.from(this).inflate(layoutResID, null)
        initDecorView()
        super.setContentView(mRootView)
    }


    /**
     * 初始化根布局
     */
    private fun initDecorView() {
        mRootView = LinearLayout(this)
        mRootView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        mRootView.orientation = LinearLayout.VERTICAL
        initToolBar()
        mRootView.addView(mToolBarLayout)
        //        mRootView.addView(mToolBar);
        mRootView.addView(mContentView)
    }

    /**
     * 初始化ToolBar
     */
    private fun initToolBar() {
        mToolBarLayout = layoutInflater.inflate(R.layout.layout_toolbar, mRootView, false) as LinearLayout
        mToolBar = mToolBarLayout.findViewById(R.id.toolbar)
        setCustomToolbar(mToolBar)
    }

    /**
     * 子类自行扩展设置属性
     * @param toolbar
     */
    protected fun setCustomToolbar(toolbar: RelativeLayout) {}


}
