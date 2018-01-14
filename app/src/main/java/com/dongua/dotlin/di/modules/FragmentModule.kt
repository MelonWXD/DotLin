package com.dongua.dotlin.di.modules

import android.view.View
import dagger.Module

/**
 * author: Lewis
 * data: On 18-1-13.
 */
@Module
class FragmentModule(val view: View) {
    fun provideView() = view
}