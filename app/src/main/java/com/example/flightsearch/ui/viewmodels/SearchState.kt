package com.example.flightsearch.ui.viewmodels

data class SearchState(
    val searchQuery: String = "",
    val autoCompleteSuggestions: List<String> = emptyList(),
    val searchResults: List<String> = emptyList()
)
