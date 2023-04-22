package com.example.flightsearch.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearch.data.repository.FavoriteRepository
import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

class FavoritesViewModel(private val favoriteRepository: FavoriteRepository): ViewModel() {
    private val _favorites: MutableStateFlow<FavoritesState> =
        MutableStateFlow(FavoritesState()) // vm reads this
    val favorites = _favorites.asStateFlow() //  the UI reads this

    init {
        getAllFavorites()
    }

    fun getAllFavorites() {
        viewModelScope.launch {
            _favorites.value = FavoritesState(favorites = favoriteRepository.getAllFavorites())
        }
    }

    fun addNewFavoriteRoute(route: Favorite) {
        viewModelScope.launch {
            favoriteRepository.insertRoute(route)
        }
    }

    fun removeFavoriteRoute(route: Favorite) {
        viewModelScope.launch {
            favoriteRepository.deleteRoute(route)
        }
    }
}