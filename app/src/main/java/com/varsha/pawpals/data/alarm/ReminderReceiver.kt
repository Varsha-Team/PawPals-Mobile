package com.varsha.pawpals.data.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val title = intent?.getStringExtra("TITLE") ?: return
        ReminderNotification().createNotification(context!!, title)
    }
}

