package com.example.flightsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearch.model.Airport
import com.example.flightsearch.ui.screens.homeScreen.HomeScreen
import com.example.flightsearch.ui.theme.FlightSearchTheme
import com.example.flightsearch.ui.viewmodels.GetFlightsViewModel
import com.example.flightsearch.ui.viewmodels.ViewModelProvider
import com.example.flightsearch.ui.viewmodels.showTypes

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
                    var viewModel: GetFlightsViewModel = viewModel(factory = ViewModelProvider.Factory)
                    HomeScreen(
                        defaultAllAirports = viewModel.defaultAllAirports,
                        airports = viewModel.searchState.autoCompleteSuggestions,
                        showType = viewModel.searchState.showType,
                        onSearchStringEdit = { searchString: String -> viewModel.updateSearchSuggestions(searchString)},
                        originAirport = viewModel.searchState.originAirport,
                        onSuggestionClicked = {airport: Airport -> viewModel.showPossibleFlights(airport)},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}