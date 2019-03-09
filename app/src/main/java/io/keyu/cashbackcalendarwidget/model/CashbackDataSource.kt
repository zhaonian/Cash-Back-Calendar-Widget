package io.keyu.cashbackcalendarwidget.model

import io.keyu.cashbackcalendarwidget.R

object CashbackDataSource {
    var cashbacks = listOf(
        Card(
            "Disc.",
            R.drawable.ic_discover_card,
            listOf(
                listOf("5% Grocery Stores"),    // Q1
                listOf("5% Gas Station", "5% Uber and Lyft"),    // Q2
                listOf("5% Restaurants"),    // Q3
                listOf("5% Amazon")     // Q4
            ),
            true
        ),
        Card(
            "Chase Freedom",
            R.drawable.ic_visa_card,
            listOf(
                listOf("5% Gas Station", "5% Tolls", "5% Drugstore"),    // Q1
                listOf("Coming Soon"),    // Q2
                listOf("Coming Soon"),    // Q3
                listOf("Coming Soon")     // Q4
            ),
            true
        ),
        Card(
            "Citi Dividend",
            R.drawable.ic_citi_card,
            listOf(
                listOf("5% Gas Station", "5% Home Depot"),    // Q1
                listOf("5% Drugstore", "Fitness Club"),    // Q2
                listOf("5% Airline", "5% Car Rental"),    // Q3
                listOf("5% Best Buy", "5% Department Store")     // Q4
            ),
            true
        ),
        Card(
            "Best Buy Visa",
            R.drawable.ic_bestbuy_card,
            listOf(
                listOf(
                    "5% Best Buy",
                    "3% Fitness",
                    "3% Sporting Goods",
                    "3% Gas Station",
                    "2% Dinning, Grocery"
                ),    // Q1
                listOf("Coming Soon"),    // Q2
                listOf("Coming Soon"),    // Q3
                listOf("Coming Soon")     // Q4
            ),
            true
        )
    )
}