package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flightsearch.model.Airport
import com.example.flightsearch.ui.viewmodels.showTypes
import kotlinx.coroutines.flow.Flow
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun HomeScreen(
    defaultAllAirports: List<Airport>,
    airports: List<Airport>,
    showType: showTypes,
    onSearchStringEdit: (String) -> Unit,
    originAirport: Airport,
    onSuggestionClicked: (Airport) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchBarString:String by remember { mutableStateOf("") }
    Column(
        modifier = modifier.padding(10.dp),
    ) {
        SearchBar(
            searchBarString = searchBarString,
            onSearchEdit = { newValue: String ->  searchBarString = newValue; onSearchStringEdit(newValue)},
            modifier = modifier
        )
        Spacer(Modifier.height(15.dp))
        ResultsScreen(defaultAllAirports = defaultAllAirports, airports = airports, originAirport = originAirport , showType = showType, onSuggestionClicked = onSuggestionClicked)
    }
}



