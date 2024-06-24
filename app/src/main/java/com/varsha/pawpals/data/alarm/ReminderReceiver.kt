package com.varsha.pawpals.data.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.varsha.pawpals.R

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val title = intent.getStringExtra("TITLE") ?: context.getString(R.string.your_notification)
        val reminderNotification = ReminderNotification(context)
        reminderNotification.sendReminderNotification(title)
    }
}
