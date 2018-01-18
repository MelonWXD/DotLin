package com.dongua.dotlin.ui.fragment


import android.graphics.drawable.Animatable
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import android.widget.ImageView
import com.dongua.dotlin.R
import com.dongua.dotlin.ui.activity.MainActivity
import com.dongua.dotlin.ui.adapter.NoteAdapter
import com.dongua.dotlin.ui.base.fragment.BaseToolBarFragment
import com.dongua.dotlin.ui.adapter.ItemDraggerCallBack
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
    lateinit var mNoteRecycler: RecyclerView

    @Inject
    lateinit var mPresenter: NotePresenter



    override fun initWidget(root: View) {
        (activity as MainActivity).mActivityConponent.getNoteFragmentComponent().inject(this)
        mPresenter.attachView(this)



        mAddNoteBtn = root.findViewById(R.id.fab_addNote)
        mNoteRecycler = root.findViewById(R.id.rv_notes)
        mNoteRecycler.layoutManager = LinearLayoutManager(activity)
        mNoteRecycler.adapter = NoteAdapter(activity)
        var itemTouchHelper = ItemTouchHelper(ItemDraggerCallBack())
        itemTouchHelper.attachToRecyclerView(mNoteRecycler)


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
