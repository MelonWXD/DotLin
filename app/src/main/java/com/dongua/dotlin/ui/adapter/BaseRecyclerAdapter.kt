package com.dongua.dotlin.ui.adapter

/**
 * author: Lewis
 * data: On 18-1-18.
 */
abstract class BaseRecyclerAdapter<T> {
    abstract fun getDataList(): List<T>
}