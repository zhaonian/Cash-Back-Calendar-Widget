package io.keyu.cashbackcalendarwidget.service

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceService {
    private const val CASHBACK_WIDGET = "Cashback Widget"
    const val DISCOVER_IT = "Discover It"
    const val CHASE_FREEDOM = "Chase Freedom"
    const val CITI_DIVIDEND = "Citi Dividend"

    private fun getSharedPreferences(ctx: Context): SharedPreferences {
        return ctx.getSharedPreferences(CASHBACK_WIDGET, Context.MODE_PRIVATE)
    }

    fun setCardVisibility(ctx: Context, cardName: String, visible: Boolean) {
        val editor = getSharedPreferences(ctx).edit()
        editor.putBoolean(cardName, visible)
        editor.apply()
    }

    fun getCardVisibility(ctx: Context, cardName: String): Boolean {
        return getSharedPreferences(ctx).getBoolean(cardName, true)
    }
}