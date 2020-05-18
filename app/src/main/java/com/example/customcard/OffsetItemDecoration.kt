package com.example.customcard

import android.content.Context
import android.graphics.Point
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ItemDecoration
import android.view.View
import android.view.ViewGroup.MarginLayoutParams


class OffsetItemDecoration() : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        //view.layoutParams.width isn't correct at this point, thus, calculate again the card width using parent's width
        val childWidth = (TriangleShapeView.factorWidth * parent.width).toInt()

        val offset = (( parent.width * 0.5 ) - ( childWidth * 0.5 )).toInt()
        val lp = view.layoutParams as MarginLayoutParams
        if (parent.getChildAdapterPosition(view) == 0) {
            (lp).leftMargin = 0
            setupOutRect(outRect, offset, true)
        } else if (parent.getChildAdapterPosition(view) == state.itemCount - 1) {
            (lp).rightMargin = 0
            setupOutRect(outRect, offset, false)
        }
    }

    private fun setupOutRect(
        rect: Rect,
        offset: Int,
        start: Boolean
    ) {
        if (start) {
            rect.left = offset
        } else {
            rect.right = offset
        }
    }

}