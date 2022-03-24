package com.runkeeper.exercise.data.model.main

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteRecordsResponse(

    @Json(name = "id")
    val id: Int,

    @Json(name = "title")
    val title: String,

    @Json(name = "label")
    val label: String,

    @Json(name = "active")
    val active: Boolean,

    @Json(name = "image")
    val image: String,
)
