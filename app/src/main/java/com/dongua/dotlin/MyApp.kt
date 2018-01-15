package com.dongua.dotlin

import android.app.Application
import com.dongua.dotlin.di.components.AppComponent
import com.dongua.dotlin.di.components.DaggerAppComponent
import com.dongua.dotlin.di.modules.AppModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger.addLogAdapter
import com.orhanobut.logger.PrettyFormatStrategy
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger


//import com.dongua.dotlin.di.components.AppComponent
//import com.dongua.dotlin.di.components.DaggerAppComponent
//import com.dongua.dotlin.di.modules.AppModule

//import com.dongua.dotlin.di.components.AppComponent

/**
 * author: Lewis
 * data: On 18-1-10.
 */
class MyApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent

    }



    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        initLog()

    }

    private fun initLog() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(1)
                .tag("WXD")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

    }
}