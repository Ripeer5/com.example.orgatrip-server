package com.example.feature_user.data

import com.example.feature_user.model.User
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.coroutine.CoroutineDatabase

interface UserDataSource {

    suspend fun saveUser(user: User)

    suspend fun fetchUser(id: String): User

    companion object {
        fun create(): UserDataSource {
            return UserDataSourceImpl(
                db = CoroutineDatabase(
                    KMongo.createClient().getDatabase("OrgaTrip")
                )
            )
        }
    }

}