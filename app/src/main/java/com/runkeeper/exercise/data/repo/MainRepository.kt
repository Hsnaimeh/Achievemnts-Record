package com.runkeeper.exercise.data.repo

import com.runkeeper.exercise.data.datasource.main.RemoteMainDataSource
import com.runkeeper.exercise.data.model.main.RemoteMedalResponse
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteMainDataSource: RemoteMainDataSource,
) {

    suspend fun getMadel(): List<RemoteMedalResponse> {
        return remoteMainDataSource.getMadel()
    }


}
