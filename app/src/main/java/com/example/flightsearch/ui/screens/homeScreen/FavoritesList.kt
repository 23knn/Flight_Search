package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite

@Composable
fun FavoritesList(favorites: List<Favorite>, findAirportByIATA: (iata: String) -> Airport?) {
    LazyColumn {
        items(favorites) { favorite ->
            To_Fro(
                origin = findAirportByIATA(favorite.departure_code)!!,
                destination = findAirportByIATA(favorite.destination_code)!!
            )

        }
    }
}