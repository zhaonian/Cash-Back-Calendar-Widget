package io.keyu.cashbackcalendarwidget.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bonus.*
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.google.android.material.snackbar.Snackbar


class BonusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(io.keyu.cashbackcalendarwidget.R.layout.activity_bonus)
        back.setOnClickListener {
            onBackPressed()
        }

        discoverIt.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("discoverIt", "http://refer.discover.com/s/pppmnw")
            clipboard.primaryClip = clip
            Snackbar.make(bonusLinearLayout, "Disc. Referral Link copied!", Snackbar.LENGTH_LONG).show()
        }

        amex.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("amex", "http://refer.amex.us/ZHAONLK3yO?xl=cp27")
            clipboard.primaryClip = clip
            Snackbar.make(bonusLinearLayout, "Amex Referral Link copied!", Snackbar.LENGTH_LONG).show()
        }

        chaseFreedom.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("freedom", "https://www.referyourchasecard.com/2/A5QA6JUCUP")
            clipboard.primaryClip = clip
            Snackbar.make(bonusLinearLayout, "Freedom Referral Link copied!", Snackbar.LENGTH_LONG).show()
        }

        share.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Discover it: http://refer.discover.com/s/pppmnw " +
                            "\n" +
                            "AMEX Marriot Bonvoy: http://refer.amex.us/ZHAONLK3yO?xl=cp27"
                )
            }
            startActivity(shareIntent)
        }
    }
}