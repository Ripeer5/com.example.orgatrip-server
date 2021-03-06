package com.example.feature_trip.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection
import java.util.UUID

@Serializable
data class Trip(
    @BsonId
    val id: String = UUID.randomUUID().toString(),
    val name: String,
/*
    val participants: List<Participant>
*/
)





