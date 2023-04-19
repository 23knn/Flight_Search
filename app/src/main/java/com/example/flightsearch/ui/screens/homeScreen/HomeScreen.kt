package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column() {
        SearchBar(onSearchEdit = { })
    }
}


fun onSearchEdit(stringValue: String) {

}