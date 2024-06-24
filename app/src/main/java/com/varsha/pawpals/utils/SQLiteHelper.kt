package com.varsha.pawpals.utils

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import com.varsha.pawpals.model.AlarmData
import com.varsha.pawpals.model.PetData
import java.nio.file.Files.delete
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 2
        private const val DATABASE_NAME = "PetsDatabase"
        private const val TABLE_PETS = "Pets"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAMA = "nama"
        private const val COLUMN_PHOTO = "photo"
        private const val COLUMN_TYPE = "type"
        private const val COLUMN_JENIS = "jenis"
        private const val COLUMN_GENDER = "gender"
        private const val COLUMN_BIRTHDAY = "birthday"

        // Constants for Alarms table
        private const val TABLE_ALARMS = "Alarms"
        private const val COLUMN_ALARM_ID = "alarm_id"
        private const val COLUMN_PET_ID = "pet_id"
        private const val COLUMN_ALARM_NAME = "alarm_name"
        private const val COLUMN_ALARM_TIME = "alarm_time"
        private const val COLUMN_DAYS = "days"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createPetsTable = ("CREATE TABLE $TABLE_PETS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAMA TEXT," +
                "$COLUMN_PHOTO INTEGER," +
                "$COLUMN_TYPE TEXT," +
                "$COLUMN_JENIS TEXT," +
                "$COLUMN_GENDER TEXT," +
                "$COLUMN_BIRTHDAY TEXT)")

        val createAlarmsTable = ("CREATE TABLE $TABLE_ALARMS (" +
                "$COLUMN_ALARM_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_PET_ID INTEGER," +
                "$COLUMN_ALARM_NAME TEXT," +
                "$COLUMN_ALARM_TIME TEXT," +
                "$COLUMN_DAYS TEXT," +
                "FOREIGN KEY($COLUMN_PET_ID) REFERENCES $TABLE_PETS($COLUMN_ID))")

        db?.execSQL(createPetsTable)
        db?.execSQL(createAlarmsTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PETS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_ALARMS")
        onCreate(db)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addPet(pet: PetData): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_NAMA, pet.nama)
            put(COLUMN_PHOTO, pet.photo)
            put(COLUMN_TYPE, pet.type)
            put(COLUMN_JENIS, pet.jenis)
            put(COLUMN_GENDER, pet.gender)
            put(COLUMN_BIRTHDAY, pet.birthday.format(DateTimeFormatter.ISO_LOCAL_DATE))
        }
        val success = db.insert(TABLE_PETS, null, contentValues)
        db.close()
        return success
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllPets(): List<PetData> {
        val petList: ArrayList<PetData> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_PETS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val pet = PetData(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                    nama = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAMA)),
                    photo = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PHOTO)),
                    type = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE)),
                    jenis = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_JENIS)),
                    gender = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENDER)),
                    birthday = LocalDate.parse(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIRTHDAY)))
                )
                petList.add(pet)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return petList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getPetById(petId: Int): PetData? {
        val db = this.readableDatabase

        val selectQuery = "SELECT * FROM $TABLE_PETS WHERE $COLUMN_ID = ?"
        val cursor = db.rawQuery(selectQuery, arrayOf(petId.toString()))
        var pet: PetData? = null


        if (cursor.moveToFirst()) {
            pet = PetData(
                id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                nama = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAMA)),
                photo = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PHOTO)),
                type = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE)),
                jenis = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_JENIS)),
                gender = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GENDER)),
                birthday = LocalDate.parse(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BIRTHDAY)))
            )
        }
        cursor.close()
        db.close()
        return pet
    }


    fun addAlarm(alarm: AlarmData): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_PET_ID, alarm.petId)
            put(COLUMN_ALARM_NAME, alarm.name)
            put(COLUMN_ALARM_TIME, alarm.time)
            put(COLUMN_DAYS, alarm.days.joinToString(","))
        }
        val success = db.insert(TABLE_ALARMS, null, contentValues)
        db.close()
        return success
    }
    
    fun deletePet(petId: Int): Int {
        val db = this.writableDatabase
        val success = db.delete(TABLE_PETS, "$COLUMN_ID=?", arrayOf(petId.toString()))
        db.close()
        return success
    }


    fun getAlarmsByPetId(petId: Int): List<AlarmData> {
        val db = this.readableDatabase
        val alarmList: ArrayList<AlarmData> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_ALARMS WHERE $COLUMN_PET_ID = ?"

        val cursor = db.rawQuery(selectQuery, arrayOf(petId.toString()))

        if (cursor.moveToFirst()) {
            do {
                val alarm = AlarmData(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ALARM_ID)),
                    petId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PET_ID)),
                    name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALARM_NAME)),
                    time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALARM_TIME)),
                    days = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DAYS)).split(",").map { it.toBoolean() }
                )
                alarmList.add(alarm)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return alarmList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updatePet(pet: PetData): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_NAMA, pet.nama)
            put(COLUMN_PHOTO, pet.photo)
            put(COLUMN_TYPE, pet.type)
            put(COLUMN_JENIS, pet.jenis)
            put(COLUMN_GENDER, pet.gender)
            put(COLUMN_BIRTHDAY, pet.birthday.format(DateTimeFormatter.ISO_LOCAL_DATE))
        }
        val success = db.update(TABLE_PETS, contentValues, "$COLUMN_ID=?", arrayOf(pet.id.toString()))
        db.close()
        return success
    }

    // Fungsi untuk mengambil semua data dari tabel ALARMS
    fun getAllAlarms(): List<AlarmData> {
        val alarmList: ArrayList<AlarmData> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_ALARMS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val alarm = AlarmData(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ALARM_ID)),
                    petId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_PET_ID)),
                    name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALARM_NAME)),
                    time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ALARM_TIME)),
                    days = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DAYS)).split(",").map { it.toBoolean() }
                )
                alarmList.add(alarm)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return alarmList
    }


}


