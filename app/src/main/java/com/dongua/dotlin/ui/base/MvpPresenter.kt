package com.dongua.dotlin.ui.base

/**
 * author: Lewis
 * data: On 18-1-11.
 */
interface MvpPresenter {

    fun attachView(view: MvpView)

    fun dettchView()

}