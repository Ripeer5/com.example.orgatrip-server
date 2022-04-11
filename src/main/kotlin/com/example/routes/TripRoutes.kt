package com.example.routes

import com.example.data.model.Trip
import com.example.room.RoomController
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.get
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

private const val BASE_URL = "http://192.168.100.65:8080"
val client = KMongo.createClient()
val database = client.getDatabase("Orgatrip")


/*listOf( Trip("RomeId", "RomeName"), Trip("ParisId", "ParisName"))*/

fun Route.tripRouting() {
    get("/trip") {
        val list: List<Trip> = database.getCollection<Trip>("trip")
            .find(Trip::name eq "LondonName").toList()
        var trip = Trip("h","r")
        for (t in list){
            if (t.name == "LondonName"){
                trip = t
            }
        }
        call.respond(
            HttpStatusCode.OK,
            trip
        )
    }

}


fun Route.getTripByIdRouting() {
    get("/trip/{id}") {
        val tripId =
            call.parameters["id"] ?: return@get call.respondText(
                "Bad request",
                status = HttpStatusCode.BadRequest
            )
        val trips = database.getCollection("trip")
        val trip = trips.find(
            /*"{_id:'LondonId'}"*/
            Trip::name eq "LondonName"
        )
        call.respond(
            HttpStatusCode.OK,
            trip
        )
    }
}
