package com.example.flightsearch.data.repository

import com.example.flightsearch.data.dao.FavoriteDAO
import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun insertRoute(route: Favorite): Unit

    suspend fun deleteRoute(route: Favorite): Unit

    fun getAllFavorites(): Flow<List<Favorite>>
}

class OfflineFavoriteRepository(private val favoriteDAO: FavoriteDAO): FavoriteRepository {
    override suspend fun insertRoute(route: Favorite) = favoriteDAO.insertRoute(route)

    override suspend fun deleteRoute(route: Favorite) = favoriteDAO.deleteRoute(route)

    override fun getAllFavorites(): Flow<List<Favorite>> = favoriteDAO.getAllFavorites()
}