package com.dongua.dotlin.di.components

import android.content.Context
import com.dongua.dotlin.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * author: Lewis
 * data: On 18-1-11.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun getAppContext(): Context
}