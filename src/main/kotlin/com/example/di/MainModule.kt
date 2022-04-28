package com.example.di

import com.example.feature_trip.data.TripDataSource
import com.example.feature_trip.data.TripDataSourceImpl
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