package com.example.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.Flow

@Dao // @Dao is what makes it a Dao, we don't need to extend/implement anything. for retrofit remember we extended retrofit
interface FavoriteDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoute(route: Favorite)

    @Delete
    suspend fun deleteRoute(route: Favorite)

    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): Flow<List<Favorite>>
}