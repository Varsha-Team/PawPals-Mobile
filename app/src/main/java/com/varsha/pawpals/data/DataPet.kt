package com.varsha.pawpals.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.varsha.pawpals.R
import com.varsha.pawpals.model.PetData
import java.time.LocalDate

object DataPet {
    @RequiresApi(Build.VERSION_CODES.O)
    val Pet = listOf(
        PetData(
            id = 1,
            nama = "Basuki",
            photo = R.drawable.pet_photo1,
            type = "Cat",
            jenis = "kucing oren",
            gender = "tidak tau",
            birthday = LocalDate.of(2020, 5, 18)
        ),
        PetData(
            id = 2,
            nama = "Boomba",
            photo = R.drawable.mrfresh,
            type = "Cat",
            jenis = "kucing oren",
            gender = "tidak tau",
            birthday = LocalDate.of(2020, 5, 18)
        )
    )
}