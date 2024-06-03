package com.varsha.pawpals.model

import java.sql.Date

data class Artikel (
    val id: Int,
    val title: String,
    val photo: Int,
    val category: String,
    val author: String,
    val date: String,
    val description: String
)

