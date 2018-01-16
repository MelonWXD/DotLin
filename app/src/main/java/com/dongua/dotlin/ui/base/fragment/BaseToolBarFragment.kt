package com.dongua.dotlin.ui.base.fragment

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
import kotlinx.android.synthetic.main.layout_toolbar_fragment.*

/**
 * author: Lewis
 * data: On 18-1-15.
 */
abstract class BaseToolBarFragment : BaseFragment() {

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
        mToolBar = mToolBarLayout.findViewById(R.id.toolbar)
        setCustomToolbar(mToolBar)

        mRootView.addView(mToolBarLayout)
        mRootView.addView(mRoot)
        return mRootView
    }


    open fun setCustomToolbar(toolbar: RelativeLayout) {
        toolbar.findViewById<ImageView>(R.id.iv_tb_back).setImageDrawable(ResourcesCompat.getDrawable(resources,R.drawable.anim_tb_back,activity.theme))
//        iv_tb_back.drawable = ResourcesCompat.getDrawable(resources,R.drawable.ic_toolbar_back,null)
    }

}
