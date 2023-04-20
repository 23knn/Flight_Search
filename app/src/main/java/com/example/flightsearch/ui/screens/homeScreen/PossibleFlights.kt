package com.example.flightsearch.ui.screens.homeScreen

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.flightsearch.model.Airport

@Composable
fun PossibleFlights(defaultAllAirports: List<Airport>, origin: Airport, modifier: Modifier = Modifier) {
    LazyColumn {
        items(defaultAllAirports) { airport ->
            if(airport != origin){
                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    To_Fro(origin = origin, destination = airport, modifier = Modifier.weight(6f))
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "star")
                    }
                }

                Spacer(modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun To_Fro(origin: Airport, destination: Airport, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Depart")
        AirportInfo(airport = origin)
        Text(text = "Arrive")
        AirportInfo(airport = destination)
    }
}