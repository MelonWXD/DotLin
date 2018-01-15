package com.dongua.dotlin.di.modules

import android.content.Context
import com.dongua.dotlin.util.ToastUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * author: Lewis
 * data: On 18-1-11.
 */
@Module
class AppModule(context: Context) {
    val appContext: Context = context

    @Provides
    @Singleton
    fun provideContext() = appContext

    @Provides
    @Singleton
    fun provideToastUtil(): ToastUtil {
        return ToastUtil(appContext)
    }
}