package io.keyu.cashbackcalendarwidget.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import io.keyu.cashbackcalendarwidget.R

class CashbackView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    private val cashbackText: TextView

    init {
        View.inflate(context, R.layout.view_cashback, this) // inflate first before set below attrs, otherwise NPE
        cashbackText = findViewById(R.id.cashbackText)
    }

    fun setCashbackEntry(entry: String) {
        cashbackText.text = entry
    }
}