package com.example.flightsearch.ui.screens.homeScreen

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
        AirportInfo(airport = it, onClicked = {it: Airport -> onSuggestionClicked(it)} , modifier = modifier)
    }
}
