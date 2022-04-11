package com.example.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

@Serializable
data class Trip(
    @BsonId
    val id: String,
    val name: String,
/*
    val participants: List<Participant>
*/
)





