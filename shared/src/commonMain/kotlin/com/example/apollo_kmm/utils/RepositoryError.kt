package com.example.apollo_kmm.utils

sealed class RepositoryErrorCode {
    object NetworkError: RepositoryErrorCode()
    object ValidationError: RepositoryErrorCode()
    object HttpError: RepositoryErrorCode()
    object UnknownError: RepositoryErrorCode()
}

data class RepositoryError(
    val errorCode: RepositoryErrorCode,
    val errorMessage: String
)


