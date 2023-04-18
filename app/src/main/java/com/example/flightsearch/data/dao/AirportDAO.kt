package com.example.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.flightsearch.model.Airport

@Dao
interface AirportDAO {
    @Query("SELECT * FROM flight_search where name LIKE ':%name%' OR iata_code LIKE '%iata_code%'")
    suspend fun findByNameOrIATA(): List<Airport>
}