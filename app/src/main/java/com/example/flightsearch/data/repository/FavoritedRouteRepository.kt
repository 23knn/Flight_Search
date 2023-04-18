package com.example.flightsearch.data.repository

import com.example.flightsearch.data.dao.FavoriteDAO
import com.example.flightsearch.model.FavoritedRoute
import kotlinx.coroutines.flow.Flow

interface FavoritedRouteRepository {
    suspend fun insertRoute(route: FavoritedRoute)

    suspend fun deleteRoute(id: Int)

    fun getAllFavorites(): Flow<List<FavoritedRoute>>
}

class OfflineFavoritedRouteRepository(private val favoriteDAO: FavoriteDAO): FavoritedRouteRepository {
    override suspend fun insertRoute(route: FavoritedRoute) = favoriteDAO.insertRoute(route)

    override suspend fun deleteRoute(id: Int) = favoriteDAO.deleteRoute(id)

    override fun getAllFavorites(): Flow<List<FavoritedRoute>> = favoriteDAO.getAllFavorites()
}