package com.example.customcard

import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.slider_item_container.view.*

class RecyclerAdapter(private val cards: ArrayList<SliderItem>) : RecyclerView.Adapter<RecyclerAdapter.CardHolder>()  {

    class CardHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        private var card: SliderItem? = null

        fun bindCard(card: SliderItem) {
            this.card = card
            view.textView.text = card.currentCard.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.CardHolder {
        val inflatedView = parent.inflate(R.layout.slider_item_container, false)
        val cardView = inflatedView.findViewById<TriangleShapeView>(R.id.cardView)
        val params = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val factorWidth= 0.75
        val factorHeight = 0.75
        val width = (factorWidth * parent.width).toInt()
        val height = (factorHeight * parent.height).toInt()

        params.width = width
        params.height = height
        //cardView.layoutParams = params

        return CardHolder(inflatedView)
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: RecyclerAdapter.CardHolder, position: Int) {
            val itemCard = cards[position]
            holder.bindCard(itemCard)
        }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
