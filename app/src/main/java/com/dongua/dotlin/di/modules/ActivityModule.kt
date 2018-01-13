package com.dongua.dotlin.di.modules

import com.dongua.dotlin.di.scopes.PerActivity
import com.dongua.dotlin.mvp.BaseView
import com.dongua.dotlin.mvp.presenter.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * author: Lewis
 * data: On 18-1-10.
 */
@Module
class ActivityModule(view:BaseView) {
    val mView:BaseView = view

    @Provides
    @PerActivity
    fun providePresenter():MainPresenter{
        return MainPresenter(mView)
    }


}