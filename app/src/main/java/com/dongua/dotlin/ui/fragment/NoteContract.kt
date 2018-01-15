package com.dongua.dotlin.ui.fragment

import com.dongua.dotlin.ui.base.MvpPresenter
import com.dongua.dotlin.ui.base.MvpView

/**
 * author: Lewis
 * data: On 18-1-15.
 */


interface NoteView : MvpView {

}

interface Presenter : MvpPresenter {
    fun addNote()
    fun delNote()
    fun updateNote()
    fun queryNote()
}

interface Model {

}


