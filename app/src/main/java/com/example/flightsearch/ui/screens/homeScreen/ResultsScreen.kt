package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.runtime.Composable
import com.example.flightsearch.model.Airport
import com.example.flightsearch.ui.viewmodels.showTypes


@Composable
fun ResultsScreen(airports: List<Airport>, originAirport: Airport, showType: showTypes, onSuggestionClicked: (Airport) -> Unit) {
    when(showType){
        showTypes.FAVORITES -> FavoritesList()
        showTypes.FLIGHTS -> PossibleFlights( airports = airports, origin = originAirport )
        else -> SearchSuggestions(airports = airports, onSuggestionClicked = onSuggestionClicked)
    }
}