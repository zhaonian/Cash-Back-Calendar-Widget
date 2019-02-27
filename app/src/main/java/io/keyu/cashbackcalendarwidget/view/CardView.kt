package io.keyu.cashbackcalendarwidget.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import io.keyu.cashbackcalendarwidget.R
import io.keyu.cashbackcalendarwidget.adapter.CashbackRecyclerViewAdapter

class CardView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    MaterialCardView(context, attrs, defStyleAttr) {

    private val cardName: TextView
    private val cardLogo: ImageView
    private val cardCashbacks: RecyclerView

    init {
        View.inflate(context, R.layout.view_card, this) // inflate first before set below attrs, otherwise NPE
        cardName = findViewById(R.id.cardName)
        cardLogo = findViewById(R.id.cardLogo)
        cardCashbacks = findViewById(R.id.cashbackList)

        cardCashbacks.apply {
            setHasFixedSize(true)
            addItemDecoration(VerticalSpaceItemDecoration(36))
            layoutManager = LinearLayoutManager(context)
            adapter = CashbackRecyclerViewAdapter()
        }
    }

    fun setCardName(name: String) {
        cardName.text = name
    }

    fun setCardLogo(@DrawableRes logo: Int) {
        cardLogo.setImageResource(logo)
    }

    fun setCardCashbacks(cashbacks: List<String>) {
        (cardCashbacks.adapter as CashbackRecyclerViewAdapter).run {
            setCashbackList(cashbacks)
            notifyDataSetChanged()
        }
    }
}