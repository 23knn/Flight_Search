package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.flightsearch.model.Airport

@Composable
fun PossibleFlights(airports: List<Airport>, origin: Airport) {
    Text(text = "Possible Flights")
}