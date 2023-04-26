package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.runtime.Composable
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite
import com.example.flightsearch.ui.viewmodels.showTypes


@Composable
fun ResultsScreen(
    favorites: List<Favorite>,
    defaultAllAirports: List<Airport>,
    airports: List<Airport>,
    originAirport: Airport,
    showType: showTypes,
    onSuggestionClicked: (Airport) -> Unit,
    findAirportByIATA: (searchTerm: String) -> Airport?
) {
    when(showType){
        showTypes.FAVORITES -> FavoritesList(
            favorites = favorites,
            findAirportByIATA = findAirportByIATA
        )
        showTypes.FLIGHTS -> PossibleFlights( defaultAllAirports = defaultAllAirports, origin = originAirport )
        else -> SearchSuggestions(airports = airports, onSuggestionClicked = onSuggestionClicked)
    }
}