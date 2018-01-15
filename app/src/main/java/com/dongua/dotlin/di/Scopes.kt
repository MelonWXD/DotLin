package com.dongua.dotlin.di

/**
 * author: Lewis
 * data: On 18-1-15.
 */
import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Created by HassanUsman on 10/09/2017.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity