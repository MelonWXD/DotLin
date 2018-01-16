package com.dongua.dotlin.ui.fragment


import android.content.Context
import android.graphics.drawable.Animatable
import android.media.Image
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.dongua.dotlin.R
import com.dongua.dotlin.ui.activity.MainActivity
import com.dongua.dotlin.ui.base.fragment.BaseToolBarFragment
import javax.inject.Inject

/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteFragment : BaseToolBarFragment(), NoteView {


    override val layoutId: Int
        get() = R.layout.fragment_note

    //    @BindView(R.id.fab_addNote)
    lateinit var mAddNoteBtn: FloatingActionButton

    @Inject
    lateinit var mPresenter: NotePresenter



    override fun initWidget(root: View) {
        (activity as MainActivity).mActivityConponent.getNoteFragmentComponent().inject(this)
        mPresenter.attachView(this)



        mAddNoteBtn = root.findViewById(R.id.fab_addNote)
        mAddNoteBtn.setOnClickListener {
            (mToolBar.findViewById<ImageView>(R.id.iv_tb_back).drawable as Animatable).start()
        }
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//
//        val rootView = inflater.inflate(R.layout.fragment_note, container, false)
//
//        mAddNoteBtn = rootView.findViewById(R.id.fab_addNote)
//        mAddNoteBtn.setOnClickListener {
//
//        }
//        return rootView
//    }


    override fun onDestroy() {
        super.onDestroy()

    }
}
