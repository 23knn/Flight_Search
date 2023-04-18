package com.example.flightsearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritedRoute(
    @PrimaryKey
    val id: Int,
    val departure_code: String,
    var destination_code: String
)
