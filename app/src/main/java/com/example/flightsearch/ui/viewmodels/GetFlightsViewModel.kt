package com.example.flightsearch.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.repository.AirportRepository
import com.example.flightsearch.data.repository.FavoriteRepository
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch



class GetFlightsViewModel(private val airportRepository: AirportRepository, private val favoriteRepository: FavoriteRepository): ViewModel() {
    var searchState by mutableStateOf(SearchState())
    var favorites: Flow<List<Favorite>> = emptyFlow()
    var defaultAllAirports: List<Airport> = emptyList()

    init {
        getAllAirports()
        getAllFavorites()
    }

    fun getAllAirports() {
        viewModelScope.launch {
            val airports = airportRepository.getAllAirports()
            searchState = searchState.copy(allAirports = airports )
            defaultAllAirports = airports
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

    fun showPossibleFlights(airport: Airport) {
        searchState = searchState.copy(
            originAirport = airport,
            showType = showTypes.FLIGHTS
        )
    }

    fun getAllFavorites() {
        viewModelScope.launch {
            favorites = favoriteRepository.getAllFavorites()
        }
    }



}