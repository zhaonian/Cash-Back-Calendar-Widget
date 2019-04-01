package io.keyu.cashbackcalendarwidget.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.cashbackcalendarwidget.model.Card
import io.keyu.cashbackcalendarwidget.view.CardView

class CardRecyclerViewAdapter : RecyclerView.Adapter<CardViewHolder>() {

    private var cardList: List<Card> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        // create a new view
        val cardView = CardView(parent.context)
        // set the view's size, margins, paddings and layout parameters
        return CardViewHolder.from(cardView)
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val curCard = cardList[position]
        holder.itemView.elevation = 0F
        holder.itemView.background.alpha = 0
        if (!curCard.visibility) {
            holder.itemView.layoutParams = ViewGroup.LayoutParams(0, 0)
            holder.itemView.visibility = View.GONE
        } else {
            holder.itemView.layoutParams =
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            holder.itemView.visibility = View.VISIBLE
            holder.cardView.apply {
                setCardName(curCard.name)
                setCardLogo(curCard.logo)
                setCardCashbacks(curCard.cashbacks[1])
            }
        }
    }

    fun setCardList(cardList: List<Card>) {
        this.cardList = cardList
        notifyDataSetChanged()
    }
}