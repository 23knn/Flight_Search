package com.example.flightsearch.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.repository.AirportRepository
import com.example.flightsearch.model.Airport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class GetFlightsViewModel(private val airportRepository: AirportRepository): ViewModel() {
    private var _searchState = MutableStateFlow(SearchState()) // the VM updates this
    val searchState: StateFlow<SearchState> = _searchState.asStateFlow() // the UI reads this
    var defaultAllAirports: List<Airport> = emptyList()

    init {
        getAllAirports()
    }

    fun getAllAirports() {
        viewModelScope.launch {
            val airports = airportRepository.getAllAirports()
            _searchState.value = SearchState(allAirports = airports )
            defaultAllAirports = airports
        }
    }

    fun updateSearchSuggestions(searchString: String) {
        viewModelScope.launch {
            _searchState.value = if(searchString == "") {
                SearchState(showType = showTypes.FAVORITES)
            } else {
                SearchState(
                    autoCompleteSuggestions = airportRepository.findByNameOrIATA("%$searchString%"),
                    showType = showTypes.SEARCH_SUGGESTIONS
                )
            }
        }
    }

    fun showPossibleFlights(airport: Airport) {
        _searchState.value = SearchState(
            originAirport = airport,
            showType = showTypes.FLIGHTS
        )
    }
}