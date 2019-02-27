package io.keyu.cashbackcalendarwidget.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.keyu.cashbackcalendarwidget.view.CashbackView

class CashbackRecyclerViewAdapter : RecyclerView.Adapter<CashbackViewHolder>() {

    private var cashbackList: List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashbackViewHolder {
        // create a new view
        val cashbackView = CashbackView(parent.context)
        // set the view's size, margins, paddings and layout parameters
        return CashbackViewHolder.from(cashbackView)
    }

    override fun getItemCount(): Int = cashbackList.size

    override fun onBindViewHolder(holder: CashbackViewHolder, position: Int) {
        val curCashback = cashbackList[position]
        holder.cashbackView.apply {
            setCashbackEntry(curCashback)
        }
    }

    fun setCashbackList(cashbackList: List<String>) {
        this.cashbackList = cashbackList
    }
}