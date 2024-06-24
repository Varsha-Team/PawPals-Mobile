package com.varsha.pawpals.model

data class AlarmData(
    val id: Int = 0,
    val petId: Int,
    val name: String,
    val time: String,
    val days: List<Boolean>
)