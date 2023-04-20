package com.example.flightsearch.ui.viewmodels

import com.example.flightsearch.model.Airport

enum class showTypes {
    FAVORITES,
    FLIGHTS,
    SEARCH_SUGGESTIONS
}
data class SearchState(
    val searchQuery: String = "",
    val autoCompleteSuggestions: List<Airport> = emptyList(),
    val searchResults: List<Airport> = emptyList(),
    val allAirports: List<Airport> = emptyList(),
    val showType: showTypes = showTypes.FAVORITES
)
