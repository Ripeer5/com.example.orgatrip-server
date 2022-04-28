package com.example.feature_user.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import kotlinx.serialization.Serializable


@Serializable
data class User(
    val email: String,
    val name: String,
    @BsonId
    val id: String = ObjectId().toString()
)
