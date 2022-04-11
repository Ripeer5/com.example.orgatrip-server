package com.example.data.model

import kotlinx.serialization.*
import org.bson.codecs.pojo.annotations.BsonId

@Serializable
data class Participant(
    @BsonId
    val id: String,
    val name: String
)
