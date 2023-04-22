package com.example.flightsearch.ui.viewmodels

import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class FavoritesState(
    val favorites: Flow<List<Favorite>> = emptyFlow()
)