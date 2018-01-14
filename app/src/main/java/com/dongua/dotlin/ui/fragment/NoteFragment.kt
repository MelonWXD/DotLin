package com.dongua.dotlin.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.dongua.dotlin.MyApp
import com.dongua.dotlin.R
import com.dongua.dotlin.di.components.DaggerActivityComponent
import com.dongua.dotlin.ui.activity.MainActivity
import com.dongua.dotlin.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_note.*
import javax.inject.Inject

/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteFragment : Fragment() {

    lateinit var mUnBind: Unbinder

//    @BindView(R.id.fab_addNote)
    lateinit var mAddNoteBtn: FloatingActionButton


    @Inject
    lateinit var mAppToast: ToastUtil

    //inject here
    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity as MainActivity).mActivityConponent.getNoteFragmentComponent().inject(this)


    }


    //    //bind here
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val rootView = inflater.inflate(R.layout.fragment_note, container, false)
//        mUnBind = ButterKnife.bind(activity, rootView)

        mAddNoteBtn = rootView.findViewById(R.id.fab_addNote)
        mAddNoteBtn.setOnClickListener {
            mAppToast.shortToast("click by app")
        }
        return rootView
    }


    override fun onDestroy() {
        super.onDestroy()
//        mUnBind.unbind()
    }
}
