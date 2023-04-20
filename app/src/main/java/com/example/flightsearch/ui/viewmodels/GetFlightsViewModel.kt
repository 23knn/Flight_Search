package com.example.flightsearch.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.repository.AirportRepository
import com.example.flightsearch.data.repository.FavoriteRepository
import kotlinx.coroutines.launch



class GetFlightsViewModel(private val airportRepository: AirportRepository, private val favoriteRepository: FavoriteRepository): ViewModel() {
    var searchState by mutableStateOf(SearchState())

    init {
        getAllAirports()
    }

    fun getAllAirports() {
        viewModelScope.launch {
            searchState = searchState.copy(allAirports = airportRepository.getAllAirports() )
        }
    }

    fun updateSearchSuggestions(searchString: String) {
        viewModelScope.launch {
            searchState = if(searchString == "") {
                searchState.copy(showType = showTypes.FAVORITES)
            } else {
                searchState.copy(
                    autoCompleteSuggestions = airportRepository.findByNameOrIATA("%$searchString%"),
                    showType = showTypes.SEARCH_SUGGESTIONS
                )
            }
        }
    }



}