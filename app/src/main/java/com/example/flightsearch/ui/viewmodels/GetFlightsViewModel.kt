package com.example.flightsearch.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.flightsearch.data.database.Flight_Search_DB
import com.example.flightsearch.data.repository.AirportRepository
import com.example.flightsearch.data.repository.FavoriteRepository

class GetFlightsViewModel(private val airportRepository: AirportRepository, private val favoriteRepository: FavoriteRepository): ViewModel() {
    var searchState by mutableStateOf(SearchState())


}