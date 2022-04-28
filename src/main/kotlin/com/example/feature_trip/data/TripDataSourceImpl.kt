package com.example.feature_trip.data

import com.example.feature_trip.data.model.Trip
import org.litote.kmongo.coroutine.CoroutineDatabase

class TripDataSourceImpl(
    val db: CoroutineDatabase
) : TripDataSource {

    private val trips = db.getCollection<Trip>()

    override suspend fun getAllTrips(): List<Trip> {
        return trips.find().toList()
    }

    override suspend fun getTripById(tripId: String): Trip {
        val trip = trips.findOne(tripId)
        if (trip != null) {
            return trip
        } else {
            throw Exception("Le voyage n'existe pas")
        }
    }

    override suspend fun insertTrip(trip: Trip) {
            trips.insertOne(trip)
    }
}