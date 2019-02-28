package io.keyu.cashbackcalendarwidget.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.cashbackcalendarwidget.view.CashbackView

class CashbackViewHolder private constructor(val cashbackView: CashbackView) :
    RecyclerView.ViewHolder(cashbackView) {
    companion object {
        @JvmStatic
        fun from(parent: ViewGroup): CashbackViewHolder = CashbackViewHolder(CashbackView(parent.context))
    }
}
