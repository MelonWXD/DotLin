package com.dongua.dotlin

import android.app.Application
import com.dongua.dotlin.di.components.AppComponent
import com.dongua.dotlin.di.components.DaggerAppComponent
import com.dongua.dotlin.di.modules.AppModule

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

    }
}