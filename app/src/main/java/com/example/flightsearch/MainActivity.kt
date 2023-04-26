package com.example.flightsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.model.Airport
import com.example.flightsearch.ui.screens.homeScreen.HomeScreen
import com.example.flightsearch.ui.theme.FlightSearchTheme
import com.example.flightsearch.ui.viewmodels.FavoritesViewModel
import com.example.flightsearch.ui.viewmodels.GetFlightsViewModel
import com.example.flightsearch.ui.viewmodels.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlightSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var flightsViewModel: GetFlightsViewModel = viewModel(factory = ViewModelProvider.Factory)
                    var favoritesViewModel: FavoritesViewModel = viewModel(factory = ViewModelProvider.Factory)

                    val searchState by flightsViewModel.searchState.collectAsState()
                    val favoritesState by favoritesViewModel.favorites.collectAsState()
                    val favorites by favoritesState.favorites.collectAsState(initial = emptyList())
                    val defaultAllAiports = flightsViewModel.defaultAllAirports

                    HomeScreen(
                        defaultAllAirports = defaultAllAiports,
                        airports = searchState.allAirports,
                        showType = searchState.showType,
                        favorites = favorites,
                        onSearchStringEdit = { searchString: String -> flightsViewModel.updateSearchSuggestions(searchString)},
                        originAirport = searchState.originAirport,
                        onSuggestionClicked = { airport: Airport -> flightsViewModel.showPossibleFlights(airport)},
                        findAirportByIATA = { searchTerm: String -> flightsViewModel.findAirportByIATA(searchTerm)},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}