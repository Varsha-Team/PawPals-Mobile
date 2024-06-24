package com.varsha.pawpals

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.google.firebase.FirebaseApp
import androidx.compose.runtime.LaunchedEffect
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.varsha.pawpals.data.alarm.ReminderNotification
import com.varsha.pawpals.ui.presentation.PawPalsApp
import com.varsha.pawpals.ui.theme.PawPalsTheme
import com.varsha.pawpals.utils.DatabaseLogger

class   MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawPalsTheme {
                FirebaseApp.initializeApp(this)
                val reminderNotification = ReminderNotification(this)
                reminderNotification.createNotificationChannel()
                val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
                LaunchedEffect(key1 = true) {
                    if (!postNotificationPermission.status.isGranted) {
                        postNotificationPermission.launchPermissionRequest()
                    }
                }
                PawPalsApp()
            }
        }
        val databaseLogger = DatabaseLogger(this)

        // Menampilkan semua data dari tabel PETS di Logcat
        databaseLogger.logAllPets()

        // Menampilkan semua data dari tabel ALARMS di Logcat
        databaseLogger.logAllAlarms()


        // Menampilkan semua data dari tabel USERS di Logcat
        databaseLogger.logAllUsers()


    }
}
