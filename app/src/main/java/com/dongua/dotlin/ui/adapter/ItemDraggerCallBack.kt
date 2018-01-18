package com.dongua.dotlin.ui.adapter

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.dongua.dotlin.R
import java.util.*
import java.util.logging.Logger


/**
 * author: Lewis
 * data: On 18-1-18.
 */
class ItemDraggerCallBack : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        if (recyclerView.layoutManager is GridLayoutManager) {

            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or
                    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            val swipeFlags = 0
            return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
        } else {
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            val swipeFlags = 0
            return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
        }


    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder
                        , target: RecyclerView.ViewHolder): Boolean {

        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap((recyclerView.adapter as NoteAdapter).dataList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap((recyclerView.adapter as NoteAdapter).dataList, i, i - 1)

            }
        }

        recyclerView.adapter.notifyItemMoved(fromPosition, toPosition)
        return true


    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            //给被拖曳的 item 设置一个深颜色背景
            viewHolder?.itemView?.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context, R.color.gray40))
            viewHolder?.itemView?.scaleX = 0.9f
            viewHolder?.itemView?.scaleY = 0.9f
        }
    }

//    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int?) {
//        super.onSelectedChanged(viewHolder, actionState)
//
//        com.orhanobut.logger.Logger.i("onSelectedChanged")
//        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
//            //给被拖曳的 item 设置一个深颜色背景
////            viewHolder.itemView.setBackgroundColor(Color.LTGRAY)
//            viewHolder.itemView.setScaleX(1.05f);
//            viewHolder.itemView.setScaleY(1.05f);
//        }
//
//
//    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder.itemView.scaleX = 1.00f
        viewHolder.itemView.scaleY = 1.00f
        viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context, R.color.mainBackground))

    }
}