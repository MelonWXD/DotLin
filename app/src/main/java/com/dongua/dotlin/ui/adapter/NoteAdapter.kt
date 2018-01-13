package com.dongua.dotlin.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.dongua.dotlin.R

/**
 * author: Lewis
 * data: On 18-1-13.
 */
class NoteAdapter(val context: Context) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var dataList: ArrayList<String> = ArrayList(10)

    init {
        for (i in 0..10) {
            dataList.add("index:" + i)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val root = LayoutInflater.from(context).inflate(R.layout.layout_recycler_drawer_item, parent, false)
        return NoteViewHolder(root)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.noteButton.text = dataList[position]
    }


    override fun getItemCount(): Int {
        return dataList.size
    }


    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noteButton: Button = itemView.findViewById(R.id.rv_drawer_btn)

    }
}