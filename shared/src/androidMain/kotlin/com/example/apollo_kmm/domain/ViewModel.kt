package com.example.apollo_kmm.domain

import androidx.lifecycle.viewModelScope as androidxViewModelScope

actual abstract class ViewModel actual constructor() : androidx.lifecycle.ViewModel() {
    actual val viewModelScope = androidxViewModelScope

    actual override fun onCleared() {
        super.onCleared()
    }
}
