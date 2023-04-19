package com.example.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.flightsearch.model.Airport

@Dao
interface AirportDAO {
    @Query("SELECT * FROM airport where name LIKE :searchTerm OR iata_code LIKE :searchTerm")
    suspend fun findByNameOrIATA(searchTerm: String): List<Airport>
    @Query("SELECT * FROM airport")
    suspend fun getAllAirports(): List<Airport>
}