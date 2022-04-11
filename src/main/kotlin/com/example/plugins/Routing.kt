package com.example.plugins

import com.example.routes.getTripByIdRouting
import com.example.routes.tripRouting
import io.ktor.application.*
import io.ktor.routing.*


fun Application.configureRouting() {

/*
    val roomController by inject<RoomController>()
*/

    routing {
        tripRouting()
        getTripByIdRouting()
    }
}
