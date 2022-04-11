package com.example.data

import com.example.data.model.Trip

interface TripDataSource {

    suspend fun getAllTrips(): List<Trip>

    suspend fun getTripById(tripId: String): Trip

    suspend fun insertTrip()

}