package com.example.flightsearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class Airport(
    @PrimaryKey
    val id: Int,
    val iata_code: String,
    var name: String,
    var passengers: Int
)
