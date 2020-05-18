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

        val firstCard = SliderItem( 1)
        val secondCard = SliderItem( 2)
        val thirdCard = SliderItem( 3)
        val sliderItems2: ArrayList<SliderItem> = arrayListOf(firstCard,secondCard,thirdCard)

        adapter = RecyclerAdapter(sliderItems2)
        recyclerView.adapter = adapter

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        val position =  (abs(sliderItems2.count() * 0.5)).toInt()
        centerAtPosition(position)
    }

    fun centerAtPosition(position: Int){
        val cardWidthMiddle = 150
        customLinearLayoutManager.scrollToPositionWithOffset(position, cardWidthMiddle);

        /*
        recyclerView.post {
            val factorWidth = 0.75
            val cardWidth = (factorWidth * recyclerView.width).toInt()
            customLinearLayoutManager.scrollToPositionWithOffset(position, (cardWidth * 0.5.toInt()))
        }
         */
    }

}
