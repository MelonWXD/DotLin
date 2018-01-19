package com.dongua.dotlin.ui.base.fragment

import android.app.ActionBar
import android.media.Image
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.dongua.dotlin.MyApp
import com.dongua.dotlin.R
import com.dongua.dotlin.util.ToastUtil
import kotlinx.android.synthetic.main.layout_toolbar_fragment.*
import com.dongua.dotlin.util.getStatusBarHeight

/**
 * author: Lewis
 * data: On 18-1-15.
 */
abstract class BaseToolBarFragment : BaseFragment() ,View.OnClickListener{

    private lateinit var mToolBarLayout: LinearLayout
    protected lateinit var mToolBar: RelativeLayout
    //根布局
    private lateinit var mRootView: LinearLayout


    override fun initRootView(mRoot: View): View {
        mRootView = LinearLayout(context)
        mRootView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        mRootView.orientation = LinearLayout.VERTICAL

        mToolBarLayout = layoutInflater.inflate(R.layout.layout_toolbar_fragment, mRootView, false) as LinearLayout
        //沉浸status
        mToolBarLayout.setPadding(mToolBarLayout.paddingLeft, getStatusBarHeight(activity), mToolBarLayout.paddingRight, mToolBarLayout.paddingBottom)
        mToolBar = mToolBarLayout.findViewById(R.id.toolbar)
        initListener(mToolBar)
        setCustomToolbar(mToolBar)


        mRootView.addView(mToolBarLayout)
        mRootView.addView(mRoot)
        return mRootView
    }

    private fun initListener(mToolBar: RelativeLayout) {
        mToolBar.findViewById<View>(R.id.iv_tb_left1).setOnClickListener(this)
        mToolBar.findViewById<View>(R.id.iv_tb_left2).setOnClickListener(this)
        mToolBar.findViewById<View>(R.id.tv_tb_title).setOnClickListener(this)
        mToolBar.findViewById<View>(R.id.iv_tb_right1).setOnClickListener(this)
        mToolBar.findViewById<View>(R.id.iv_tb_right2).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        ToastUtil.shortToast(context,"${v.javaClass.name} is clicked")
        if (v.visibility != View.VISIBLE)
            return
        onToolBarClick(v)
    }

    open fun onToolBarClick(v: View) {

    }

    open fun setCustomToolbar(toolbar: RelativeLayout) {
        mToolBar.findViewById<ImageView>(R.id.iv_tb_left1).setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.anim_tb_back, activity.theme))
//        mToolBar.findViewById<ImageView>(R.id.iv_tb_left1).setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_toolbar_back, activity.theme))

//        iv_tb_left1.drawable = ResourcesCompat.getDrawable(resources,R.drawable.ic_toolbar_back,null)
    }

}
