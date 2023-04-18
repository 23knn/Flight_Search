package com.example.flightsearch.data.repository

interface AirportRepository {
    suspend fun findByNameOrIATA(searchTerm: String): List<com.example.flightsearch.model.Airport>
}

class OfflineAirportRepository(private val airportDAO: com.example.flightsearch.data.dao.AirportDAO): AirportRepository {
    override suspend fun findByNameOrIATA(searchTerm: String): List<com.example.flightsearch.model.Airport> = airportDAO.findByNameOrIATA(searchTerm)
}