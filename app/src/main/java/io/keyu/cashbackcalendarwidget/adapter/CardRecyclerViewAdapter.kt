package io.keyu.cashbackcalendarwidget.adapter

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
        holder.cardView.apply {
            setCardName(curCard.name)
            setCardLogo(curCard.logo)
            setCardCashbacks(listOf("adfas", "adfs", "Asdfa"))
        }
    }

    fun setCardList(cardList: List<Card>) {
        this.cardList = cardList
    }
}