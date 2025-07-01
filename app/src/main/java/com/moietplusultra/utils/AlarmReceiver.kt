package com.moietplusultra.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val title = intent?.getStringExtra("title") ?: "Routine"
        val message = intent?.getStringExtra("message") ?: "Il est temps d’agir pour toi."

        NotificationUtils.showNotification(context, title, message)
        NotificationUtils.vibrate(context)
    }
}
