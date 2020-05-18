package com.example.customcard

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Recycler
import android.view.View
import kotlin.math.abs


class CustomLinearLayoutManager(context: Context?) : LinearLayoutManager(context) {
    private val mShrinkAmount = 0.15f
    private val mShrinkDistance = 1.0f
    override fun scrollVerticallyBy(
        dy: Int,
        recycler: Recycler,
        state: RecyclerView.State
    ): Int {
        val orientation = orientation
        return if (orientation == VERTICAL) {
            val scrolled = super.scrollVerticallyBy(dy, recycler, state)
            val midpoint = height / 2.0f
            val d0 = 0.0f
            val d1 = mShrinkDistance * midpoint
            val s0 = 1.0f
            val s1 = 1.0f - mShrinkAmount
            // loop through active children and set scale of child
            for (i in 0 until childCount) {
                val child: View? = getChildAt(i)
                val childMidpoint =
                    (child?.let { getDecoratedBottom(it) }?.plus(getDecoratedTop(child)))?.div(2.0f)
                val d = d1.coerceAtMost(abs(midpoint - childMidpoint!!))
                val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
                child.scaleX = scale
                child.scaleY = scale
            }
            scrolled
        } else {
            0
        }
    }

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: Recycler,
        state: RecyclerView.State
    ): Int {
        val orientation = orientation
        return if (orientation == HORIZONTAL) {
            val scrolled = super.scrollHorizontallyBy(dx, recycler, state)
            val midpoint = width / 2.0f
            val d0 = 0.0f
            val d1 = mShrinkDistance * midpoint
            val s0 = 1.0f
            val s1 = 1.0f - mShrinkAmount
            // loop through active children and set scale of child
            for (i in 0 until childCount) {
                val child: View? = getChildAt(i)
                val childMidpoint =
                    (child?.let { getDecoratedRight(it) }?.plus(getDecoratedLeft(child)))?.div(2.0f)
                val d = d1.coerceAtMost(abs(midpoint - childMidpoint!!))
                val scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0)
                child.scaleX = scale
                child.scaleY = scale
            }
            scrolled
        } else {
            0
        }
    }

    override fun onLayoutChildren(
        recycler: Recycler,
        state: RecyclerView.State
    ) {
        super.onLayoutChildren(recycler, state)
        scrollVerticallyBy(0, recycler, state)
        scrollHorizontallyBy(0, recycler, state)
    }
}