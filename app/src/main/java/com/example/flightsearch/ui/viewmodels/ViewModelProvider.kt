package com.example.flightsearch.ui.viewmodels

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightSearchApp

class ViewModelProvider {
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as FlightSearchApp)
                val container = app.container
                GetFlightsViewModel(container.offlineAirportRepository)
            }

            initializer {
                val app = (this[APPLICATION_KEY] as FlightSearchApp)
                val container = app.container
                FavoritesViewModel(container.offlineFavoriteRepository)
            }
        }
    }
}