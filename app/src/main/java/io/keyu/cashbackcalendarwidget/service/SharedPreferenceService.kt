package io.keyu.cashbackcalendarwidget.service

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceService {
    private const val CASHBACK_WIDGET = "cashbackwidget"
    const val DISCOVER_IT = "discover_it"
    const val CHASE_FREEDOM = "chase_freedom"
    const val CITI_DIVIDEND = "citi_dividend"

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