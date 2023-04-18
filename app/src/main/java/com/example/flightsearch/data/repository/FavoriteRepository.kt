package com.example.flightsearch.data.repository

import com.example.flightsearch.data.dao.FavoriteDAO
import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun insertRoute(route: Favorite)

    suspend fun deleteRoute(id: Int)

    fun getAllFavorites(): Flow<List<Favorite>>
}

class OfflineFavoriteRepository(private val favoriteDAO: FavoriteDAO): FavoriteRepository {
    override suspend fun insertRoute(route: Favorite) = favoriteDAO.insertRoute(route)

    override suspend fun deleteRoute(id: Int) = favoriteDAO.deleteRoute(id)

    override fun getAllFavorites(): Flow<List<Favorite>> = favoriteDAO.getAllFavorites()
}