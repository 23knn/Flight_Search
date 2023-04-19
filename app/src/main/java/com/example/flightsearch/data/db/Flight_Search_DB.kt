package com.example.flightsearch.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flightsearch.data.dao.AirportDAO
import com.example.flightsearch.data.dao.FavoriteDAO
import com.example.flightsearch.model.Airport
import com.example.flightsearch.model.Favorite


@Database(entities = [Airport::class, Favorite::class], version = 1, exportSchema = false)
abstract class Flight_Search_DB: RoomDatabase() { // the db is now a subclass of room database
    /**
     * edit, exposes the DAO. the structure is: view model asks repository for data. repository asks dao. db exposes dao to repository
     * */
    abstract fun airportDAO(): AirportDAO
    abstract fun favoriteDAO(): FavoriteDAO

    // return db instance or make one if it doesn't exist
    companion object {
        @Volatile
        private var Instance: Flight_Search_DB? = null
        fun getDBInstance(context: Context): Flight_Search_DB {
            val TAG: String = "INSTANCE"

            return Instance ?: synchronized(this){

                Log.d(TAG, "NO INSTANCE" )
                Room.databaseBuilder(context, Flight_Search_DB::class.java,"flight_db")
                    .createFromAsset("database/flight_search.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {Instance = it; Log.d(TAG, "INSTANCE MADE" )}

            }
        }
    }
}