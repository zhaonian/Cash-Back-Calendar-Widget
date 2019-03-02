package io.keyu.cashbackcalendarwidget.service

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import io.keyu.cashbackcalendarwidget.R

class CashbackWidgetService : RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent?): RemoteViewsFactory {
        return CashbackWidgetItemFactory(applicationContext, p0)
    }

    class CashbackWidgetItemFactory(private val context: Context, intent: Intent?) : RemoteViewsFactory {

        private val widgetId =
            intent?.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
        private val dummyData = arrayListOf("hehe", "haha", "xixi")

        override fun onCreate() {
            // connect to data source

        }

        override fun getLoadingView(): RemoteViews? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun onDataSetChanged() {
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        override fun getViewAt(p0: Int): RemoteViews {
            val views = RemoteViews(context.packageName, R.layout.widget_cashback_item)
            views.setTextViewText(R.id.widgetItemText, dummyData[p0])
            return views
        }

        override fun getCount(): Int {
            return dummyData.size
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun onDestroy() {
            // close data source
        }
    }
}