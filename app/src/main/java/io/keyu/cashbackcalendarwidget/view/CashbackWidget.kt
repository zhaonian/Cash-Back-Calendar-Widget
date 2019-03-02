package io.keyu.cashbackcalendarwidget.view

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import io.keyu.cashbackcalendarwidget.R
import io.keyu.cashbackcalendarwidget.service.CashbackWidgetService

/**
 * Implementation of App Widget functionality.
 */
class CashbackWidget : AppWidgetProvider() {


    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    companion object {

        internal fun updateAppWidget(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {
            val serviceIntent = Intent(context, CashbackWidgetService::class.java)
            serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            serviceIntent.data =
                Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME))
            // let the OS know each widget is independent. different widgets can hold different data

            // Construct the RemoteViews object
            val views = RemoteViews(context.packageName, R.layout.widget_cashback)
            views.setRemoteAdapter(R.id.listView, serviceIntent)
            views.setEmptyView(R.id.listView, R.id.emptyListView)
            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)

            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.listView)
        }
    }
}

