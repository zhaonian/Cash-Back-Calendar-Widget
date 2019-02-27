package io.keyu.cashbackcalendarwidget.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.cashbackcalendarwidget.view.CardView

class CardViewHolder private constructor(val cardView: CardView) :
    RecyclerView.ViewHolder(cardView) {
    companion object {
        @JvmStatic
        fun from(parent: ViewGroup): CardViewHolder = CardViewHolder(CardView(parent.context))
    }
}
