package com.dongua.dotlin.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dongua.dotlin.R
import com.dongua.dotlin.ui.activity.MainActivity
import javax.inject.Inject

/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteFragment : Fragment(),NoteView {



//    @BindView(R.id.fab_addNote)
    lateinit var mAddNoteBtn: FloatingActionButton

    @Inject
    lateinit var mPresenter:NotePresenter




    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity as MainActivity).mActivityConponent.getNoteFragmentComponent().inject(this)
        mPresenter.attachView(this)


    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val rootView = inflater.inflate(R.layout.fragment_note, container, false)

        mAddNoteBtn = rootView.findViewById(R.id.fab_addNote)
        mAddNoteBtn.setOnClickListener {

        }
        return rootView
    }


    override fun onDestroy() {
        super.onDestroy()

    }
}
