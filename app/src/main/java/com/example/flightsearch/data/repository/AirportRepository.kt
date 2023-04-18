package com.example.flightsearch.data.repository

import com.example.flightsearch.data.dao.AirportDAO

interface AirportRepository {
    suspend fun findByNameOrIATA(searchTerm: String): List<com.example.flightsearch.model.Airport>
}

class OfflineAirportRepository(private val airportDAO: AirportDAO): AirportRepository {
    override suspend fun findByNameOrIATA(searchTerm: String): List<com.example.flightsearch.model.Airport> = airportDAO.findByNameOrIATA(searchTerm)
}