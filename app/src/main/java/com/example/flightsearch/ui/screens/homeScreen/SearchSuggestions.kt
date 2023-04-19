package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.flightsearch.model.Airport

@Composable
fun SearchSuggestions(airports: List<Airport>, modifier: Modifier = Modifier) {
    airports.forEach { it ->
        Suggestion(airport = it, modifier = modifier)
    }
}

@Composable
fun Suggestion(airport: Airport, modifier: Modifier = Modifier) {
    Text(text = airport.name)
}