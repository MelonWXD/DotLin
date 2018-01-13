package com.dongua.dotlin.di.scopes

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * author: Lewis
 * data: On 18-1-10.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity
