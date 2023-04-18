package com.example.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flightsearch.model.FavoritedRoute
import kotlinx.coroutines.flow.Flow

@Dao // @Dao is what makes it a Dao, we don't need to extend/implement anything. for retrofit remember we extended retrofit
interface FavoriteDAO {
    @Insert
    suspend fun insertRoute(route: FavoritedRoute)

    @Delete
    suspend fun deleteRoute(id: Int)

    @Query("SELECT * FROM favoritedRoute")
    fun getAllFavorites(): Flow<List<FavoritedRoute>>
}