package com.example.flightsearch.ui.viewmodels

import com.example.flightsearch.model.Airport

data class SearchState(
    val searchQuery: String = "",
    val autoCompleteSuggestions: List<Airport> = emptyList(),
    val searchResults: List<Airport> = emptyList(),
    val allAirports: List<Airport> = emptyList()
)
