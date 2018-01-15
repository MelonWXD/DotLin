package com.dongua.dotlin.ui.base.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * author: Lewis
 * data: On 18-1-15.
 */
abstract class BaseFragment : Fragment() {

    private lateinit var mInflater: LayoutInflater
    protected lateinit var mContext: Context
    protected lateinit var mRoot: View
    protected var mBundle: Bundle? = null//获取setArguments的值


    protected abstract val layoutId: Int

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }


    override fun onDetach() {
//        mContext = null
        super.onDetach()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBundle = arguments
        //mBundle非空判断是否要放在base?
        initArguments(mBundle)
        initBundle(savedInstanceState)


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        saveBundle(outState)
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mInflater = inflater
        mRoot = inflater.inflate(layoutId, container, false)

        mRoot = initRootView(mRoot)
        initWidget(mRoot)
        initData()

        return mRoot
    }

    open protected fun initRootView(mRoot: View): View {
        return mRoot
    }

    open protected fun initArguments(arguments: Bundle?) {}

    open protected fun initBundle(savedInstanceState: Bundle?) {

    }

    open protected fun saveBundle(outState: Bundle) {

    }

    open protected fun initWidget(root: View){}

    open protected fun initData(){}
}
