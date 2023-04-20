package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.flightsearch.model.Airport

@Composable
fun PossibleFlights(airports: List<Airport>, origin: Airport) {
    airports.forEach { it ->
        if(it != origin){
            Row() {
                Text(text = origin.name)
                Text(text = it.name)
            }
        }
    }
}