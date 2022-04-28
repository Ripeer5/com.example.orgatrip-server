package com.example.feature_user.data

import com.example.core.Constants.USER_DB_NAME
import com.example.feature_user.model.User
import org.litote.kmongo.coroutine.CoroutineDatabase

class UserDataSourceImpl(
    val db: CoroutineDatabase
): UserDataSource {

    override suspend fun saveUser(user: User) {
        db.getCollection<User>(USER_DB_NAME).insertOne(user)
    }

    override suspend fun fetchUser(id: String): User {
        return db.getCollection<User>(USER_DB_NAME).findOne(id) ?: User("error", "error")
    }
}