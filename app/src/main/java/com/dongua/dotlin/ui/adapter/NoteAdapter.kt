package com.dongua.dotlin.ui.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.dongua.dotlin.R
import java.util.*
import com.dongua.dotlin.R.id.swipeLayout
import com.dongua.dotlin.bean.Note
import com.dongua.dotlin.util.ToastUtil
import android.support.graphics.drawable.VectorDrawableCompat
import android.support.v4.content.ContextCompat


/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteAdapter(val context: Context,val listener: OnItemClickListener) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    enum class ImportantLevel {
        URGENT, NORMAL, EASE
    }

    companion object {
        val URGENT: Int = 1
        val NORMAL = 2
        val EASE = 3
    }

    var dataList: ArrayList<Note> = ArrayList(10)
    var isSeeFlag = true

    init {
        for (i in 0..10) {
            dataList.add(Note("note$i", Random().nextInt(3)+1))
        }
        dataList.add(Note("note11", Random().nextInt(3)+1,true))

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.layout_recycler_note_item, parent, false)
        return NoteViewHolder(root)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
//        holder.itemView.setBackgroundColor(Color.LTGRAY)
//        if(!isSeeFlag)
//            return
        holder.itemView.setOnClickListener{
            listener.onItemClick(position)
        }

        holder.noteText.text = dataList[position].content

        holder.doneCheck.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                holder.noteText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            else
                holder.noteText.paintFlags = 0

        }
        if(dataList[position].isDone){
            holder.doneCheck.performClick()
        }
        val vectorDrawableCompat = VectorDrawableCompat.create(context.resources, R.drawable.svg_tag, context.theme)
        when (dataList[position].impLevel) {
            URGENT -> vectorDrawableCompat!!.setTint(ContextCompat.getColor(context, R.color.red500))
            NORMAL -> vectorDrawableCompat!!.setTint(ContextCompat.getColor(context, R.color.yellow500))
            EASE -> vectorDrawableCompat!!.setTint(ContextCompat.getColor(context, R.color.green500))
        }
        holder.levelImage.setImageDrawable(vectorDrawableCompat)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noteText: TextView = itemView.findViewById(R.id.tv_note)
        var doneCheck: CheckBox = itemView.findViewById(R.id.cb_done)
        var levelImage: ImageView = itemView.findViewById(R.id.iv_level)

    }


}