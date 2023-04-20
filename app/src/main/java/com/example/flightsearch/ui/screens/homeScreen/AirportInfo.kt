package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flightsearch.model.Airport

@Composable
fun AirportInfo(airport:Airport, onClicked: (airport: Airport) -> Unit = {}, modifier:Modifier = Modifier) {
    Row(modifier = modifier.clickable { onClicked(airport) }) {
        Text(
            airport.iata_code,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(end = 5.dp)
        )
        Text(airport.name)
    }
}