package com.example.customcard

import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_item.view.*

class RecyclerAdapter(private val cards: ArrayList<Card>) :
    RecyclerView.Adapter<RecyclerAdapter.CardHolder>() {

    class CardHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
        private var card: Card? = null

        fun bindCard(card: Card) {
            this.card = card
            view.textView.text = card.currentCard.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.CardHolder {
        val inflatedView = parent.inflate(R.layout.card_item, false)
        val cardView = inflatedView.findViewById<CardShapeView>(R.id.cardView)
        val params = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val width = (CardShapeView.factorWidth * parent.width).toInt()
        val height = (CardShapeView.factorHeight * parent.height).toInt()

        params.width = width
        params.height = height
        cardView.layoutParams = params

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
