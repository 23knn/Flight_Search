package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite
import com.example.flightsearch.ui.viewmodels.showTypes


@Composable
fun HomeScreen(
    defaultAllAirports: List<Airport>,
    airports: List<Airport>,
    showType: showTypes,
    favorites: List<Favorite>,
    onSearchStringEdit: (String) -> Unit,
    originAirport: Airport,
    findAirportByIATA: (searchTerm: String) -> Airport?,
    onSuggestionClicked: (Airport) -> Unit,

    modifier: Modifier = Modifier
) {
    var searchBarString:String by remember { mutableStateOf("") }
    Column(
        modifier = modifier.padding(10.dp),
    ) {
        SearchBar(
            searchBarString = searchBarString,
            onSearchEdit = { newValue: String ->  searchBarString = newValue; onSearchStringEdit(newValue)},
            modifier = modifier
        )
        Spacer(Modifier.height(15.dp))
        ResultsScreen(
            favorites = favorites,
            defaultAllAirports = defaultAllAirports,
            airports = airports,
            originAirport = originAirport ,
            showType = showType,
            onSuggestionClicked = onSuggestionClicked,
            findAirportByIATA = findAirportByIATA,
        )
    }
}



