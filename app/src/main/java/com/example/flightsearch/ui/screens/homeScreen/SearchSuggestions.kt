package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flightsearch.model.Airport

@Composable
fun SearchSuggestions(
    airports: List<Airport>,
    onSuggestionClicked: (Airport) -> Unit,
    modifier: Modifier = Modifier
) {
    airports.forEach { it ->
        Suggestion(airport = it, { airport: Airport -> onSuggestionClicked(airport) }, modifier = modifier)
    }
}

@Composable
fun Suggestion(airport: Airport, onAirportClicked: (Airport) -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = { onAirportClicked(airport) }) {
        Text(text = airport.iata_code, fontWeight = FontWeight.Bold, modifier = Modifier.padding(end = 5.dp))
        Text(text = airport.name)
    }
}