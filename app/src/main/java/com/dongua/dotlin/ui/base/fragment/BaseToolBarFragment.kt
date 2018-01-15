package com.dongua.dotlin.ui.base.fragment

import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.dongua.dotlin.R

/**
 * author: Lewis
 * data: On 18-1-15.
 */
abstract class BaseToolBarFragment : BaseFragment() {

    private lateinit var mToolBarLayout: RelativeLayout
    private lateinit var mToolBar: RelativeLayout
    //根布局
    private lateinit var mRootView: LinearLayout


    override fun initRootView(mRoot: View): View {
        mRootView = LinearLayout(context)
        mRootView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        mRootView.orientation = LinearLayout.VERTICAL

        mToolBarLayout = layoutInflater.inflate(R.layout.layout_toolbar_fragment, mRootView, false) as RelativeLayout
        mToolBar = mToolBarLayout.findViewById(R.id.toolbar)
        setCustomToolbar(mToolBar)

        mRootView.addView(mToolBarLayout)
        mRootView.addView(mRoot)
        return mRootView
    }


    open fun setCustomToolbar(toolbar: RelativeLayout) {

    }

}
