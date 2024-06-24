package com.varsha.pawpals.data.alarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import com.varsha.pawpals.MainActivity
import com.varsha.pawpals.R
import com.varsha.pawpals.model.alarm.NotificationKey

class ReminderNotification(private val context: Context) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun sendReminderNotification(title: String?) {
        val intent = Intent(context,  MainActivity::class.java)

        val pendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        }

        val notification = NotificationCompat.Builder(context, NotificationKey.RMNDR_NOTI_CHNNL_ID)
            .setContentTitle(title)
//            .setContentText(context.getString(R.string.app_name))
            .setSmallIcon(R.drawable.logo_pawpals)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.logo_pawpals))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.logo_pawpals)))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(NotificationKey.RMNDR_NOTI_ID, notification)
    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NotificationKey.RMNDR_NOTI_CHNNL_ID,
                NotificationKey.RMNDR_NOTI_CHNNL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel for reminder notifications"
            }
            notificationManager.createNotificationChannel(channel)
        }
    }
}


