package com.example.routes

import com.example.data.model.Trip
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

private const val BASE_URL = "http://192.168.1.81:8080"
val client = KMongo.createClient()
val database = client.getDatabase("OrgaTrip")


/*listOf( Trip("RomeId", "RomeName"), Trip("ParisId", "ParisName"))*/

fun Route.tripRouting() {
    route("/trip") {
        get {
            val list: List<Trip> = database.getCollection<Trip>("trip")
                .find(Trip::name eq "LondonName").toList()
            var trip = Trip("h", "r")
            for (t in list) {
                if (t.name == "LondonName") {
                    trip = t
                }
            }
            call.respond(
                HttpStatusCode.OK,
                trip
            )
        }
        get("/{id}") {

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
        post {
            try{
                val trip = call.receive<Trip>()
                database.getCollection<Trip>("trip").insertOne(trip)
                call.respondText("Trip registred correctly", status = HttpStatusCode.Created)
            }catch (e: Exception) {
                throw Exception("erreur d'ecriture", e.cause)
            }
        }
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
