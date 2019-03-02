package io.keyu.cashbackcalendarwidget.service

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import io.keyu.cashbackcalendarwidget.R
import io.keyu.cashbackcalendarwidget.model.CashbackDataSource

class CashbackWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return CashbackWidgetItemFactory(applicationContext)
    }

    class CashbackWidgetItemFactory(private val context: Context) : RemoteViewsFactory {

        private var cashbackList = CashbackDataSource.cashbacks

        override fun onCreate() {
            // connect to data source
            cashbackList.map { card ->
                card.visibility = SharedPreferenceService.getCardVisibility(context, card.name)
            }
        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun onDataSetChanged() {
            cashbackList.map { card ->
                card.visibility = SharedPreferenceService.getCardVisibility(context, card.name)
            }
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun getViewAt(p0: Int): RemoteViews {
            val views = RemoteViews(context.packageName, R.layout.widget_cashback_item)
            views.setTextViewText(R.id.widgetItemName, cashbackList[p0].name)
            views.setTextViewText(
                R.id.widgetItemCashbacks,
                cashbackList[p0].cashbacks[0].joinToString(separator = "\n")
            )
            views.setViewVisibility(R.id.widgetItem, if (cashbackList[p0].visibility) View.VISIBLE else View.GONE)

            return views
        }

        override fun getCount(): Int {
            return cashbackList.size
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun onDestroy() {
            // close data source
        }
    }
}