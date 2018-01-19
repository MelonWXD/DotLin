package com.dongua.dotlin.ui.fragment


import android.media.Image
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.dongua.dotlin.R
import com.dongua.dotlin.ui.activity.MainActivity
import com.dongua.dotlin.ui.adapter.NoteAdapter
import com.dongua.dotlin.ui.base.fragment.BaseToolBarFragment
import com.dongua.dotlin.ui.adapter.ItemDraggerCallBack
import com.dongua.dotlin.ui.adapter.OnItemClickListener
import com.dongua.dotlin.ui.adapter.OnSwipeListener
import com.dongua.dotlin.util.ToastUtil
import javax.inject.Inject


/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteFragment : BaseToolBarFragment(), NoteView, OnSwipeListener, OnItemClickListener {


    override val layoutId: Int
        get() = R.layout.fragment_note

    //    @BindView(R.id.fab_addNote)
    lateinit var mAddNoteBtn: FloatingActionButton
    lateinit var mNoteRecycler: RecyclerView

    @Inject
    lateinit var mPresenter: NotePresenter


    lateinit var mSeeImg: ImageView
    var isSeeFlag = true


    override fun initWidget(root: View) {
        (activity as MainActivity).mActivityConponent.getNoteFragmentComponent().inject(this)
        mPresenter.attachView(this)



        mAddNoteBtn = root.findViewById(R.id.fab_addNote)
        mNoteRecycler = root.findViewById(R.id.rv_notes)
        mNoteRecycler.layoutManager = LinearLayoutManager(activity)
        mNoteRecycler.adapter = NoteAdapter(activity,this)
        val itemTouchHelper = ItemTouchHelper(ItemDraggerCallBack(this))

        itemTouchHelper.attachToRecyclerView(mNoteRecycler)


        mAddNoteBtn.setOnClickListener {
            //            (mToolBar.findViewById<ImageView>(R.id.iv_tb_back).drawable as Animatable).start()
            showCustomDialog()
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

    override fun setCustomToolbar(toolbar: RelativeLayout) {
        super.setCustomToolbar(toolbar)

        mSeeImg = toolbar.findViewById(R.id.iv_tb_right2)
        mSeeImg.visibility = View.VISIBLE
        mSeeImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.svg_see))


    }

    override fun onToolBarClick(v: View) {
        super.onToolBarClick(v)
        when (v.id) {
            R.id.iv_tb_left1 -> {
            }
            R.id.iv_tb_right2 -> {
                if (isSeeFlag) {
                    mSeeImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.svg_nosee))
                } else {
                    mSeeImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.svg_see))
                }
                isSeeFlag = !isSeeFlag
                (mNoteRecycler.adapter as NoteAdapter).isSeeFlag = isSeeFlag
                mNoteRecycler.adapter.notifyDataSetChanged()
            }
        }
    }

    fun showCustomDialog() {
        val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.fragment_note_edit)
        builder.show()


//        val contentView1 = LayoutInflater.from(this).inflate(
//                R.layout.activity_send_peisong, null)
//        dialog1.setContentView(contentView1)
//        dialog1.setTitle("配送费用")
//        dialog1.setCanceledOnTouchOutside(true)
//        seekBar = contentView1.findViewById(R.id.seekBar11) as SeekBar
//        num_tv = contentView1.findViewById(R.id.num_tv) as TextView
//        val price_cancle = contentView1
//                .findViewById(R.id.s_cancel) as Button
//        val price_true = contentView1.findViewById(R.id.s_ok) as Button
    }

    //will not call
    override fun onEdit(pos: Int) {
        ToastUtil.shortToast(context, "onEdit:$pos")
        mNoteRecycler.adapter.notifyItemChanged(pos)
    }

    override fun onRemove(pos: Int) {
        (mNoteRecycler.adapter as NoteAdapter).dataList.removeAt(pos)
        mNoteRecycler.adapter.notifyItemRemoved(pos)
    }

    override fun onItemClick(pos: Int) {
        ToastUtil.shortToast(context, "onClick:$pos")

    }
}
