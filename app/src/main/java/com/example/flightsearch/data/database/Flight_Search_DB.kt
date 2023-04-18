package com.example.flightsearch.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flightsearch.data.repository.AirportRepository
import com.example.flightsearch.data.repository.FavoritedRouteRepository
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.FavoritedRoute


@Database(entities = [Airport::class, FavoritedRoute::class], version = 1, exportSchema = false)
abstract class Flight_Search_DB: RoomDatabase() { // the db is now a subclass of room database
    // expose the repositories for this db
    abstract fun airportRepository(): AirportRepository
    abstract fun favoritedRouteRepository(): FavoritedRouteRepository

    // return db instance or make one if it doesn't exist
    companion object {
        var Instance: Flight_Search_DB? = null

        fun getDBInstance(context: Context): Flight_Search_DB {
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context = context, klass =  Flight_Search_DB::class.java, name= "flight_search")
                    .createFromAsset("database/flight_search.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {Instance = it}
            }
        }
    }
}