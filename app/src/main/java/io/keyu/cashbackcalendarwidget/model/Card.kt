package io.keyu.cashbackcalendarwidget.model

/**
 * cashbacks: each sublist matches to each period(quarter most likely).
 * each sublist contains a list of Strings that indicate the cashback benefits
 */
data class Card(val name: String, val cashbacks: List<List<String>>)