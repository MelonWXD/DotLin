package com.dongua.dotlin.di.components

import com.dongua.dotlin.di.modules.FragmentModule
import com.dongua.dotlin.di.scopes.PerActivity
import com.dongua.dotlin.ui.fragment.NoteFragment
import dagger.Subcomponent

/**
 * author: Lewis
 * data: On 18-1-13.
 */

@Subcomponent
interface NoteFragmentComponent {
    fun inject(fragment: NoteFragment)
}
