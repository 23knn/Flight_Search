package com.example.flightsearch.ui.screens.homeScreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.flightsearch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(onSearchEdit: ()-> Unit, modifier: Modifier = Modifier) {
    TextField(value = stringResource(id = R.string.search_text_field), onValueChange = {newValue -> onSearchEdit()})
}