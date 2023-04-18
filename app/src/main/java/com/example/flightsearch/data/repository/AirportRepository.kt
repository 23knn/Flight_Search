package com.example.flightsearch.data.repository

import com.example.flightsearch.data.dao.AirportDAO
import com.example.flightsearch.model.Airport

interface AirportRepository {
    suspend fun findByNameOrIATA(searchTerm: String): List<Airport>
}

class OfflineAirportRepository(private val airportDAO: AirportDAO): AirportRepository {
    override suspend fun findByNameOrIATA(searchTerm: String): List<Airport> = airportDAO.findByNameOrIATA(searchTerm)
}