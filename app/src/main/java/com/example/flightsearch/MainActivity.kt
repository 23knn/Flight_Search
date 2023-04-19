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
import com.example.flightsearch.ui.screens.homeScreen.HomeScreen
import com.example.flightsearch.ui.theme.FlightSearchTheme
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
                    var viewModel: GetFlightsViewModel = viewModel(factory = ViewModelProvider.Factory)
                    HomeScreen(
                        airports = viewModel.searchState.autoCompleteSuggestions,
                        onSearchStringEdit = { searchString: String -> viewModel.updateSearchSuggestions(searchString)},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}