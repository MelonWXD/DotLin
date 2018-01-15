package com.dongua.dotlin.di.modules


import com.dongua.dotlin.di.PerActivity
import com.dongua.dotlin.ui.base.MvpView
import com.dongua.dotlin.ui.fragment.NotePresenter
import dagger.Module
import dagger.Provides

/**
 * author: Lewis
 * data: On 18-1-10.
 */
@Module
class ActivityModule(view: MvpView) {
    val mView: MvpView = view


    @Provides
    @PerActivity
    fun provideNotePresenter(): NotePresenter {
        return NotePresenter()
    }


}