package com.varsha.pawpals.utils

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

class DatabaseLogger(context: Context) {
    private val db = SQLiteHelper(context)

    // Fungsi untuk menampilkan semua data dari tabel PETS di Logcat
    @RequiresApi(Build.VERSION_CODES.O)
    fun logAllPets() {
        val pets = db.getAllPets()
        for (pet in pets) {
            Log.d("DatabaseLogger", "Pet ID: ${pet.id}, Name: ${pet.nama}, Type: ${pet.type}, Photo: ${pet.photo}, Jenis: ${pet.jenis}, Gender: ${pet.gender}, Birthday: ${pet.birthday}")
        }
    }

    // Fungsi untuk menampilkan semua data dari tabel ALARMS di Logcat
    fun logAllAlarms() {
        val alarms = db.getAllAlarms()
        for (alarm in alarms) {
            Log.d("DatabaseLogger", "Alarm ID: ${alarm.id}, Pet ID: ${alarm.petId}, Name: ${alarm.name}, Time: ${alarm.time}, Days: ${alarm.days}")
        }
    }

    // Fungsi untuk menampilkan semua data dari tabel ALARMS di Logcat
    fun logAllUsers() {
        val users = db.getAllUsers()
        for (user in users) {
            Log.d("DatabaseLogger", "User ID: ${user.id}, Name: ${user.nama}, Email: ${user.email}, foto: ${user.photo}, nomor: ${user.nomor}, pass: ${user.pass}")
        }
    }
}
