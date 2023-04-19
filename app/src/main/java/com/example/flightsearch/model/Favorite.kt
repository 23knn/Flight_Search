package com.example.flightsearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey
    val id: Int,
    val departure_code: String,
    var destination_code: String
)
