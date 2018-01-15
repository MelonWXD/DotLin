package com.dongua.dotlin.ui.fragment

import com.dongua.dotlin.ui.base.MvpView

/**
 * author: Lewis
 * data: On 18-1-15.
 */
class NotePresenter : Presenter {
    var mView: MvpView? =null


    override fun attachView(view: MvpView) {
        mView = view
    }

    override fun dettchView() {
        mView = null
    }

    override fun addNote() {
    }

    override fun delNote() {
    }

    override fun updateNote() {
    }

    override fun queryNote() {
    }
}