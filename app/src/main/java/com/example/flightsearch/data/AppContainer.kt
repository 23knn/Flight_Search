package com.example.flightsearch.data

import android.content.Context
import com.example.flightsearch.data.db.Flight_Search_DB
import com.example.flightsearch.data.repository.AirportRepository
import com.example.flightsearch.data.repository.FavoriteRepository
import com.example.flightsearch.data.repository.OfflineAirportRepository
import com.example.flightsearch.data.repository.OfflineFavoriteRepository

interface AppContainer {
    val offlineAirportRepository: AirportRepository
    val offlineFavoriteRepository: FavoriteRepository
}

class DefaultAppContainer(context: Context): AppContainer {
    override val offlineAirportRepository: AirportRepository by lazy {
        OfflineAirportRepository(Flight_Search_DB.getDBInstance(context).airportDAO())
    }
    override val offlineFavoriteRepository: FavoriteRepository by lazy {
        OfflineFavoriteRepository(Flight_Search_DB.getDBInstance(context).favoriteDAO())
    }
}