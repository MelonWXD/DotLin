package com.dongua.dotlin.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.dongua.dotlin.MyApp
import com.dongua.dotlin.R
import com.dongua.dotlin.di.components.ActivityComponent
import com.dongua.dotlin.di.components.DaggerActivityComponent
import com.dongua.dotlin.di.modules.ActivityModule
import com.dongua.dotlin.ui.adapter.DrawerAdapter
import com.dongua.dotlin.ui.base.MvpView

import com.dongua.dotlin.ui.adapter.NoteAdapter
import com.dongua.dotlin.ui.base.activity.BaseActivity
import com.dongua.dotlin.ui.fragment.NoteFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * author: Lewis
 * data: On 18-1-10.
 */
// DrawerLayout不能和动态添加的Toolbar公用
class MainActivity : BaseActivity(), MvpView {
    override val layoutId: Int
        get() = R.layout.activity_main


    @Inject
    lateinit var mAppContext: Context

    lateinit var mActivityConponent: ActivityComponent


    override fun initWidget() {

        mActivityConponent = DaggerActivityComponent.builder()
                .appComponent(MyApp.appComponent)
                .activityModule(ActivityModule(this))
                .build()
        mActivityConponent.inject(this)


        initDrawer()
        initFragment()
    }

    override fun initData() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun initDrawer() {
        rv_drawer_left.layoutManager = LinearLayoutManager(this)
        rv_drawer_left.adapter = DrawerAdapter(this)


    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_drawer_content, NoteFragment())
                .commit()
    }

}

