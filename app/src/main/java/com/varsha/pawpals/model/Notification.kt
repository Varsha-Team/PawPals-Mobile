package com.varsha.pawpals.model

data class Notification (
    val id : Int,
    val user : String,
    val content : String,
    val photo : Int?,
    val time : Int
)
