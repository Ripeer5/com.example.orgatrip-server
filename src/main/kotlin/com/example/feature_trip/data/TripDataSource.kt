package com.example.feature_trip.data

import com.example.feature_trip.data.model.Trip
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.coroutine.CoroutineDatabase

interface TripDataSource {

    suspend fun getAllTrips(): List<Trip>

    suspend fun getTripById(tripId: String): Trip

    suspend fun insertTrip(trip: Trip)

    companion object {
        fun create(): TripDataSource {
            return TripDataSourceImpl(db = CoroutineDatabase(KMongo.createClient().getDatabase("OrgaTrip")))
        }
    }

}