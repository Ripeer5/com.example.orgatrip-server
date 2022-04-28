package com.example.routes

import com.example.feature_user.data.UserDataSource
import com.example.feature_user.model.User
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


fun Route.userRouting() {
    val api = UserDataSource.create()

    route("/user") {

        post {
            try {
                val userToInsert = call.receive<User>()
                /*api.saveUser(userToInsert)*/
                val db = CoroutineDatabase(
                    KMongo.createClient().coroutine.client.getDatabase("trip_db")
                )
                db.getCollection<User>().insertOne(User("t", "h", "h"))
            } catch (e: Exception) {
                throw Exception("erreur d'ecriture ${e.localizedMessage}", e.cause)
            }
        }

        get("/{id}") {
            val userToGet = call.parameters["id"] ?: return@get
            call.respondText(
                "Bad Request",
                status = HttpStatusCode.BadRequest
            )

        }
    }
}