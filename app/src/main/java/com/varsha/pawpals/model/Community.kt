package com.varsha.pawpals.model

data class Community(
    val id : Int,
    val user : String,
    val title : String,
    val content : String,
    val muchLike : Int,
    val muchComment : Int,
    val time : Int
)