package com.example

import com.example.data.model.Trip
import io.ktor.application.*
import com.example.plugins.*
import org.koin.ktor.ext.inject
import org.litote.kmongo.KMongo
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.getCollection

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {



    configureRouting()
    configureSerialization()
}
