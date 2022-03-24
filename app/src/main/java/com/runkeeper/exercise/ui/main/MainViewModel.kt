package com.runkeeper.exercise.ui.main

import android.os.RemoteException
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runkeeper.exercise.data.model.main.RemoteMedalResponse
import com.runkeeper.exercise.data.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
) : ViewModel() {

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> = _loadingState

    private val _responseAdsState = mutableStateOf<List<RemoteMedalResponse>?>(null)
    val responseAdsState: State<List<RemoteMedalResponse>?> = _responseAdsState


    init {
        viewModelScope.launch {
            _loadingState.value = true
            try {
                _responseAdsState.value = mainRepository.getMadel()

            } catch (remoteException: RemoteException) {

            }
            _loadingState.value = false
        }
    }
}
