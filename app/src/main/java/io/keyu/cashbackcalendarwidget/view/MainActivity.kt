package io.keyu.cashbackcalendarwidget.view

import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.app_bar_main.toolbar
import kotlinx.android.synthetic.main.app_bar_main.fab
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.net.Uri
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import io.keyu.cashbackcalendarwidget.R
import io.keyu.cashbackcalendarwidget.adapter.CardRecyclerViewAdapter
import io.keyu.cashbackcalendarwidget.model.Card
import io.keyu.cashbackcalendarwidget.model.CashbackDataSource
import io.keyu.cashbackcalendarwidget.service.SharedPreferenceService
import android.content.ComponentName

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var data: List<Card> = CashbackDataSource.cashbacks
    private lateinit var cardList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        cardList = findViewById(R.id.cardList)
        // staggerd cards grid
        cardList.apply {
            setHasFixedSize(true)
            addItemDecoration(VerticalSpaceItemDecoration(18))
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = CardRecyclerViewAdapter().apply { setCardList(data) }
        }

        // dialog box
        fab.setOnClickListener {
            val selectionView = layoutInflater.inflate(R.layout.view_cards_selection, null, false)

            val discoverIt = selectionView.findViewById<CheckBox>(R.id.discoverIt)
            setCheckbox(discoverIt, SharedPreferenceService.DISCOVER_IT)

            val discoverMore = selectionView.findViewById<CheckBox>(R.id.discoverMore)
            setCheckbox(discoverMore, SharedPreferenceService.DISCOVER_MORE)

            val chaseFreedom = selectionView.findViewById<CheckBox>(R.id.chaseFreedom)
            setCheckbox(chaseFreedom, SharedPreferenceService.CHASE_FREEDOM)

            val citiDividend = selectionView.findViewById<CheckBox>(R.id.citiDividend)
            setCheckbox(citiDividend, SharedPreferenceService.CITI_DIVIDEND)

            val bestBuy = selectionView.findViewById<CheckBox>(R.id.bestBuy)
            setCheckbox(bestBuy, SharedPreferenceService.BESTBUY_VISA)

            AlertDialog.Builder(this).setView(selectionView).create().show()
        }

        // drawer
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_darkmode -> {
                // Handle the darkmode action
            }
            R.id.nav_share -> {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "A simple and fast way to check all your credit cards cash back categories: https://play.google.com/store/apps/details?id=$packageName"
                    )
                }
                startActivity(shareIntent)
            }
            R.id.nav_rate -> {
                val uri = Uri.parse("market://details?id=$packageName")
                val appLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
                try {
                    startActivity(appLinkToMarket)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(this, " unable to find the app in the market", Toast.LENGTH_LONG).show()
                }
            }
            R.id.nav_bonus -> {
                val bonusIntent = Intent(this, BonusActivity::class.java)
                startActivity(bonusIntent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setCheckbox(checkbox: CheckBox, cardConstName: String) {
        checkbox.isChecked =
            SharedPreferenceService.getCardVisibility(this, cardConstName)
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                SharedPreferenceService.setCardVisibility(this, cardConstName, true)
            } else {
                SharedPreferenceService.setCardVisibility(this, cardConstName, false)
            }
            data.map { card ->
                if (card.name == cardConstName) {
                    card.visibility = isChecked
                }
            }
            (cardList.adapter as CardRecyclerViewAdapter).setCardList(data)

            // update widget
            val appWidgetManager = AppWidgetManager.getInstance(this)
            val ids = appWidgetManager.getAppWidgetIds(ComponentName(this, CashbackWidget::class.java))
            for (id in ids) {
                CashbackWidget.updateAppWidget(this, appWidgetManager, id)
            }
        }
    }
}
