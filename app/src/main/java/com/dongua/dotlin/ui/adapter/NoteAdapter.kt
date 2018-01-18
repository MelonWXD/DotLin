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
import android.widget.TextView
import com.dongua.dotlin.R
import java.util.*
import com.dongua.dotlin.R.id.swipeLayout



/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteAdapter(val context: Context) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var dataList: ArrayList<String> = ArrayList(10)

    init {
        for (i in 0..10) {
            dataList.add("note:" + i)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.layout_recycler_note_item, parent, false)
        return NoteViewHolder(root)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
//        holder.itemView.setBackgroundColor(Color.LTGRAY)
        holder.noteText.text = dataList[position]
        holder.doneCheck.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked)
                holder.noteText.paintFlags= Paint.STRIKE_THRU_TEXT_FLAG
            else
                holder.noteText.paintFlags= 0

        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noteText: TextView = itemView.findViewById(R.id.tv_note)
        var doneCheck:CheckBox = itemView.findViewById(R.id.cb_done)

    }


}