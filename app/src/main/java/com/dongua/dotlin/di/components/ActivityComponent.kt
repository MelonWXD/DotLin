package com.dongua.dotlin.di.components

import com.dongua.dotlin.ui.activity.MainActivity
import com.dongua.dotlin.di.modules.ActivityModule
import com.dongua.dotlin.di.modules.FragmentModule
import com.dongua.dotlin.di.scopes.PerActivity
import com.dongua.dotlin.ui.fragment.NoteFragment
import dagger.Component

/**
 * author: Lewis
 * data: On 18-1-10.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class)
        , modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)
    fun getNoteFragmentComponent(): NoteFragmentComponent
}