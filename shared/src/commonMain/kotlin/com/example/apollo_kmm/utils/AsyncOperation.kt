package com.example.apollo_kmm.utils

sealed class AsyncOperation<out T> {
    object Loading : AsyncOperation<Nothing>()
    data class Failed(val error: Throwable) : AsyncOperation<Nothing>()
    data class Loaded<out Value>(val value: Value?) : AsyncOperation<Value>()
}

