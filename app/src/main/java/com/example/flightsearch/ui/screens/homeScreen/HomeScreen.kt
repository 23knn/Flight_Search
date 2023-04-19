package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.flightsearch.model.Airport
import kotlinx.coroutines.flow.Flow


@Composable
fun HomeScreen(airports: List<Airport>, onSearchStringEdit: (String) -> Unit, modifier: Modifier = Modifier) {
    var searchBarString:String by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        SearchBar(
            searchBarString = searchBarString,
            onSearchEdit = { newValue: String ->  searchBarString = newValue; onSearchStringEdit(newValue)},
            modifier = modifier
        )
        SearchSuggestions(airports = airports, modifier = modifier)
    }
}


