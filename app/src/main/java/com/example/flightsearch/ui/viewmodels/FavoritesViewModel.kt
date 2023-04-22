package com.example.flightsearch.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.flightsearch.data.repository.FavoriteRepository
import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FavoritesViewModel(private val favoriteRepository: FavoriteRepository): ViewModel() {
    private var _favorites:MutableStateFlow<List<Favorite>> = favoriteRepository.getAllFavorites() as MutableStateFlow<List<Favorite>>
    val favorites: StateFlow<List<Favorite>> = _favorites.asStateFlow()


}