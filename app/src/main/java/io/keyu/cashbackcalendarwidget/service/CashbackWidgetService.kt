package io.keyu.cashbackcalendarwidget.service

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import io.keyu.cashbackcalendarwidget.R
import io.keyu.cashbackcalendarwidget.model.CashbackDataSource


class CashbackWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return CashbackWidgetItemFactory(applicationContext, p0)
    }

    class CashbackWidgetItemFactory(private val context: Context, intent: Intent?) : RemoteViewsFactory {

        private val widgetId =
            intent?.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
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
            views.setTextViewText(R.id.widgetItemText, cashbackList[p0].name)
            views.setViewVisibility(R.id.widgetItemText, if (cashbackList[p0].visibility) View.VISIBLE else View.GONE)

//            val refreshIntent = Intent()
//            refreshIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId)
//            views.setOnClickFillInIntent(R.id.widgetItemText, refreshIntent)

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