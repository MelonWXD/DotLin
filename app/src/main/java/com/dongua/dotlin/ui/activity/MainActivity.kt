package com.dongua.dotlin.ui.activity

import android.support.v4.app.Fragment
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Adapter
import com.dongua.dotlin.MyApp
import com.dongua.dotlin.R
import com.dongua.dotlin.di.components.ActivityComponent
import com.dongua.dotlin.di.components.DaggerActivityComponent
import com.dongua.dotlin.di.modules.ActivityModule
import com.dongua.dotlin.di.modules.AppModule
import com.dongua.dotlin.mvp.BaseView
import com.dongua.dotlin.mvp.presenter.MainPresenter
import com.dongua.dotlin.ui.adapter.NoteAdapter
import com.dongua.dotlin.ui.fragment.NoteFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * author: Lewis
 * data: On 18-1-10.
 */
class MainActivity : AppCompatActivity(), BaseView {

    @Inject
    lateinit var mPresenter:MainPresenter

    @Inject
    lateinit var mAppContext:Context

    lateinit var mActivityConponent:ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mActivityConponent = DaggerActivityComponent.builder()
                .appComponent(MyApp.appComponent)
                .activityModule(ActivityModule(this))
                .build()

        initRecyclerView()
        initFragment()
    }

    private fun initRecyclerView(){
        rv_drawer_left.layoutManager = LinearLayoutManager(this)
        rv_drawer_left.adapter = NoteAdapter(this)


    }
    private fun initFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_drawer_content, NoteFragment())
                .commit()
    }

    override fun attach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dettch() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
