package com.dongua.dotlin.ui.base

/**
 * author: Lewis
 * data: On 18-1-15.
 */
interface BasePresenter {
    fun onAttach(mvpView: MvpView)

    fun onDetach()
}