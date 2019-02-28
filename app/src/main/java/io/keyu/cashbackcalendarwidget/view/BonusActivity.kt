package io.keyu.cashbackcalendarwidget.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.keyu.cashbackcalendarwidget.R
import kotlinx.android.synthetic.main.activity_bonus.back
import kotlinx.android.synthetic.main.activity_bonus.share

class BonusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bonus)
        back.setOnClickListener {
            onBackPressed()
        }

        share.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Discover it: http://refer.discover.com/s/pppmnw \nAMEX Marriot Bonvoy: http://refer.amex.us/ZHAONLK3yO?xl=cp27"
                )
            }
            startActivity(shareIntent)
        }
    }
}