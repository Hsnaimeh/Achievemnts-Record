package com.runkeeper.exercise.data.datasource.main

import com.runkeeper.exercise.data.model.main.RemoteMedalResponse
import com.serjltt.moshi.adapters.Wrapped
import retrofit2.http.GET

interface RemoteMainDataSource {

    @GET("/achievements")
    @Wrapped(path = ["data"])
    suspend fun getMadel(): List<RemoteMedalResponse>

}
