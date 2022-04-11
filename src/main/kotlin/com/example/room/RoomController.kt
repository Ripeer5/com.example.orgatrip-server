package com.example.room

import com.example.data.TripDataSource
import com.example.data.model.Trip

class RoomController(
    private val tripDataSource: TripDataSource
) {

    suspend fun getAllTrips(): List<Trip> {
        return tripDataSource.getAllTrips()
    }

    suspend fun getTrip(tripId: String): Trip {
        return tripDataSource.getTripById(tripId)
    }

    suspend fun insertTrip() {
        tripDataSource.insertTrip()
    }
}