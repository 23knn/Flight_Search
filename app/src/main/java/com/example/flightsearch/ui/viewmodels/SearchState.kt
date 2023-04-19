package com.example.flightsearch.ui.viewmodels

import com.example.flightsearch.model.Airport

data class SearchState(
    val searchQuery: String = "",
    val autoCompleteSuggestions: List<String> = emptyList(),
    val searchResults: List<String> = emptyList(),
    val allAirports: List<Airport> = emptyList()
)
