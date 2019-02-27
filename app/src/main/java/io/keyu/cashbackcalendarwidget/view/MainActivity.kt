package io.keyu.cashbackcalendarwidget.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import io.keyu.cashbackcalendarwidget.R
import io.keyu.cashbackcalendarwidget.adapter.CardRecyclerViewAdapter
import io.keyu.cashbackcalendarwidget.model.CashbackDataSource
import kotlinx.android.synthetic.main.view_card_list.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val cardListAdapter = CardRecyclerViewAdapter().apply { setCardList(CashbackDataSource.cashbacks) }
        cardList.apply {
            setHasFixedSize(true)
            addItemDecoration(VerticalSpaceItemDecoration(18))
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = cardListAdapter
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

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
                // Handle the camera action
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
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
