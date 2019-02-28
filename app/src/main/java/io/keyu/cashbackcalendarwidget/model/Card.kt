package io.keyu.cashbackcalendarwidget.model

import androidx.annotation.DrawableRes

/**
 * cashbacks: each sublist matches to each period(quarter most likely).
 * each sublist contains a list of Strings that indicate the cashback benefits
 */
data class Card(
    val name: String,
    @DrawableRes val logo: Int,
    val cashbacks: List<List<String>>,
    val visibility: Boolean
)