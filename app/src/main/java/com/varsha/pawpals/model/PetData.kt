package com.varsha.pawpals.model

import java.time.LocalDate

data class PetData(
    val id: Int,
    val nama: String,
    val photo: Int,
    val type: String,
    val jenis: String,
    val gender: String,
    val birthday: LocalDate,
)
