package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.runtime.Composable
import com.example.flightsearch.model.Airport
import com.example.flightsearch.ui.viewmodels.showTypes


@Composable
fun ResultsScreen(airports: List<Airport>, showType: showTypes) {

    when(showType){
        showTypes.FAVORITES -> FavoritesList()
        showTypes.FLIGHTS -> PossibleFlights()
        else -> SearchSuggestions(airports = airports)
    }

}