package com.example.flightsearch.data.repository

import com.example.flightsearch.data.dao.FavoritedRouteDAO
import com.example.flightsearch.model.FavoritedRoute
import kotlinx.coroutines.flow.Flow

interface FavoritedRouteRepository {
    suspend fun insertRoute(route: FavoritedRoute)

    suspend fun deleteRoute(id: Int)

    fun getAllFavorites(): Flow<List<FavoritedRoute>>
}

class OfflineFavoritedRouteRepository(private val favoritedRouteDAO: FavoritedRouteDAO): FavoritedRouteRepository {
    override suspend fun insertRoute(route: FavoritedRoute) = favoritedRouteDAO.insertRoute(route)

    override suspend fun deleteRoute(id: Int) = favoritedRouteDAO.deleteRoute(id)

    override fun getAllFavorites(): Flow<List<FavoritedRoute>> = favoritedRouteDAO.getAllFavorites()
}