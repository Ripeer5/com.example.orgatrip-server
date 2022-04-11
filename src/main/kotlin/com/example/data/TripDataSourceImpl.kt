package com.example.data

import com.example.data.model.Participant
import com.example.data.model.Trip
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

    override suspend fun insertTrip() {
        val bob = Participant("bobId", "Bob")
        val jack = Participant("jackId", "Jack")
        val participants = listOf(bob, jack)

        val trip = Trip(
            "trip1Id",
            "trip1Name",
/*
            participants
*/
        )
        trips.insertOne(trip)
    }
}