package com.example.di

import com.example.data.TripDataSource
import com.example.data.TripDataSourceImpl
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {

    single {
        KMongo.createClient().coroutine.getDatabase("trip_db")
    }

    single<TripDataSource> {
        TripDataSourceImpl(get())
    }
}