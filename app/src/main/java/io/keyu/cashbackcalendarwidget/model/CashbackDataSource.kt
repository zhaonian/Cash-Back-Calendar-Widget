package io.keyu.cashbackcalendarwidget.model

import io.keyu.cashbackcalendarwidget.R

object CashbackDataSource {
    var cashbacks = listOf(
        Card(
            "Discover It",
            R.drawable.ic_discover_card,
            listOf(
                listOf("5% Grocery Stores"),    // Q1
                listOf("5% at Pornhub", "5% at sadTolls", "5% at ads"),    // Q2
                listOf("5% at Gas sd", "5% at daf", "12% at Drugstorasdfes"),    // Q3
                listOf("5% at Gas ads", "5% at Tolls", "1% at Drugstores")     // Q4
            ),
            true
        ),
        Card(
            "Discover More",
            R.drawable.ic_discover_card,
            listOf(
                listOf("5% Grocery Stores"),    // Q1
                listOf("5% at Pornhub", "5% at sadTolls", "5% at ads"),    // Q2
                listOf("5% at Gas sd", "5% at daf", "12% at Drugstorasdfes"),    // Q3
                listOf("5% at Gas ads", "5% at Tolls", "1% at Drugstores")     // Q4
            ),
            true
        ),
        Card(
            "Chase Freedom",
            R.drawable.ic_visa_card,
            listOf(
                listOf("5% Gas Stations", "5% Tolls", "5% Drugstores"),    // Q1
                listOf("5% at Pornhub", "5% at sadTolls", "5% at ads"),    // Q2
                listOf("5% at Gas sd", "5% at daf", "12% at Drugstorasdfes"),    // Q3
                listOf("5% at Gas ads", "5% at Tolls", "1% at Drugstores")     // Q4
            ),
            true
        ),
        Card(
            "Citi Dividend",
            R.drawable.ic_citi_card,
            listOf(
                listOf("5% Gas Stations", "5% Home Depot"),    // Q1
                listOf("5% at Pornhub", "5% at sadTolls", "5% at ads"),    // Q2
                listOf("5% at Gas sd", "5% at daf", "12% at Drugstorasdfes"),    // Q3
                listOf("5% at Gas ads", "5% at Tolls", "1% at Drugstores")     // Q4
            ),
            true
        ),
        Card(
            "Best Buy Visa",
            R.drawable.ic_bestbuy_card,
            listOf(
                listOf("5% Best Buy", "3% Gas Stations", "2% Dinning"),    // Q1
                listOf("5% at Pornhub", "5% at sadTolls", "5% at ads"),    // Q2
                listOf("5% at Gas sd", "5% at daf", "12% at Drugstorasdfes"),    // Q3
                listOf("5% at Gas ads", "5% at Tolls", "1% at Drugstores")     // Q4
            ),
            true
        )
    )
}