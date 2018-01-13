package com.dongua.dotlin.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dongua.dotlin.R
import kotlinx.android.synthetic.main.fragment_note.*

/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteFragment : Fragment() {

    //inject here
    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }


    //    //bind here
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater!!.inflate(R.layout.fragment_note, container, false)
        fab_addNote?.setOnClickListener {
            Log.i("wxd", "click" + Thread.currentThread().name)
            Toast.makeText(activity, "click", Toast.LENGTH_SHORT).show()
        }
        return rootView
    }

    //unbinder
    override fun onDestroy() {
        super.onDestroy()
    }
}
