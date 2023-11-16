package com.example.apollo_kmm.utils

import com.apollographql.apollo3.exception.ApolloHttpException
import com.apollographql.apollo3.exception.ApolloNetworkException

object AsyncError {

    fun getRepositoryError(error: Throwable): RepositoryError {
        return when (error) {
            is ApolloNetworkException -> {
                RepositoryError(
                    errorCode = RepositoryErrorCode.NetworkError,
                    errorMessage = Message.NETWORK_ERROR
                )
            }
            is ApolloHttpException -> {
                RepositoryError(
                    errorCode = RepositoryErrorCode.HttpError,
                    errorMessage = Message.SOMETHING_WENT_WRONG
                )
            }
            else  -> {
                RepositoryError(
                    errorCode = RepositoryErrorCode.UnknownError,
                    errorMessage = Message.UNKNOWN_ERROR
                )
            }
        }
    }
}