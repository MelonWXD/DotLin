package com.dongua.dotlin.ui.fragment

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import com.dongua.dotlin.R
import com.dongua.dotlin.bean.Note
import com.dongua.dotlin.ui.base.fragment.BaseFragment
import com.dongua.dotlin.ui.base.fragment.BaseToolBarFragment

/**
 * author: Lewis
 * data: On 18-1-19.
 */
class EditFragment : BaseToolBarFragment() {
    companion object {
        val BUNDLE_TAB_BEAN = "note_bean"

        fun newInstance(bean: Note): EditFragment {

            val fragment = EditFragment()
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_TAB_BEAN, bean)
            fragment.arguments = bundle
            return fragment

        }
    }

    override val layoutId: Int
        get() = R.layout.fragment_note_edit

    lateinit var mCrossImg: ImageView
    lateinit var mTickImg: ImageView
    lateinit var mAlertImg: ImageView
    lateinit var mLevelImg: ImageView
    var mBean: Note? = null

    lateinit var mContentEt: EditText


    override fun initArguments(arguments: Bundle?) {
        if (arguments == null)
            return
        mBean = arguments.getSerializable(BUNDLE_TAB_BEAN) as Note
    }

    override fun initWidget(root: View) {
        mContentEt = root.findViewById(R.id.et_content)
        if (mBean != null) {
            mContentEt.setText((mBean as Note).content)
        }

    }

    override fun initData() {

        if (mBean != null) {
            mContentEt.setText((mBean as Note).content)
        }
    }

    override fun onToolBarClick(v: View) {
        when (v.id) {
            R.id.iv_tb_left1 -> {

            }
            R.id.iv_tb_right1 -> {

            }
        }
    }

    override fun setCustomToolbar(toolbar: RelativeLayout) {
//        super.setCustomToolbar(toolbar)

        mCrossImg = toolbar.findViewById(R.id.iv_tb_left1)
        mTickImg = toolbar.findViewById(R.id.iv_tb_right1)
        mAlertImg = toolbar.findViewById(R.id.iv_tb_right2)
        mLevelImg = toolbar.findViewById(R.id.iv_tb_left2)

        mCrossImg.visibility = View.VISIBLE
        mTickImg.visibility = View.VISIBLE
        mAlertImg.visibility = View.VISIBLE
        mLevelImg.visibility = View.VISIBLE

        mCrossImg.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.svg_cross))
        mTickImg.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.svg_tick))
        mAlertImg.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.svg_clock))
        mLevelImg.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.svg_color))
    }
}