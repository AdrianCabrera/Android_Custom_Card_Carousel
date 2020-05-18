package com.example.customcard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SnapHelper
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var customLinearLayoutManager: CustomLinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewPager)

        customLinearLayoutManager = CustomLinearLayoutManager(this)
        customLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = customLinearLayoutManager

        val firstCard = Card(1)
        val secondCard = Card(2)
        val thirdCard = Card(3)
        val cards: ArrayList<Card> = arrayListOf(firstCard, secondCard, thirdCard)

        adapter = RecyclerAdapter(cards)
        recyclerView.adapter = adapter

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.addItemDecoration(OffsetItemDecoration())

        val position = (abs(cards.count() * 0.5)).toInt()
        centerAtPosition(position)
    }

    fun centerAtPosition(position: Int) {
        recyclerView.post {
            val cardWidth = CardShapeView.factorWidth * recyclerView.width
            val centerRecyclerViewPoint = recyclerView.width * 0.5
            val center = centerRecyclerViewPoint - (cardWidth * 0.5)
            customLinearLayoutManager.scrollToPositionWithOffset(position, center.toInt())
        }

    }

}
