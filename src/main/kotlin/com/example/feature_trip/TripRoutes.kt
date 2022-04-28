package com.example.routes

import com.example.feature_trip.data.TripDataSource
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

private const val BASE_URL = "http://192.168.1.81:8080"
/*val client = KMongo.createClient()
val database = client.getDatabase("OrgaTrip")*/


/*listOf( Trip("RomeId", "RomeName"), Trip("ParisId", "ParisName"))*/

fun Route.tripRouting() {

    val api = TripDataSource.create()

    route("/trip") {
        get {
            val listTrip= api.getAllTrips()
                    /*List<Trip> = database.getCollection<Trip>("trip").find().toList()*/
            call.respond(
                HttpStatusCode.OK,
                listTrip
            )
        }
       /* get("/{id}") {

            val tripId =
                call.parameters["id"] ?: return@get call.respondText(
                    "Bad request",
                    status = HttpStatusCode.BadRequest
                )

            *//*val trips = database?.getCollection<Trip>("trip")*//*

            *//*val trip = trips?.findOne(
                Trip::id eq tripId
            ) ?: Trip("erreurId", "erreurName")
*//*
            call.respond(
                HttpStatusCode.OK,
                trip
            )
        }
        post {
            try{
                val trip = call.receive<Trip>()
                database.getCollection<Trip>("trip").insertOne(trip)
                call.respondText("Trip registred correctly", status = HttpStatusCode.Created)
            }catch (e: Exception) {
                throw Exception("erreur d'ecriture", e.cause)
            }
        }*/
    }

}


/*fun Route.getTripByIdRouting() {
    get("/trip/{id}") {

        val tripId =
            call.parameters["id"] ?: return@get call.respondText(
                "Bad request",
                status = HttpStatusCode.BadRequest
            )

        val trips = database?.getCollection<Trip>("trip")

        val trip = trips?.findOne(
            Trip::id eq tripId
        ) ?: Trip("erreurId", "erreurName")

        call.respond(
            HttpStatusCode.OK,
            trip
        )
    }
}*/
