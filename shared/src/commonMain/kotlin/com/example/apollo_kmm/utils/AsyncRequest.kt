package com.example.apollo_kmm.utils

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

abstract class AsyncRequest {

    suspend fun<T> apiCall(call: suspend () -> Result<T>) = flow<AsyncOperation<T>> {
        call.invoke()
            .onSuccess {
                emit(AsyncOperation.Loaded(it))
            }.onFailure {
                emit(AsyncOperation.Failed(it))
            }
    }.onStart {
        emit(AsyncOperation.Loading)
    }

}