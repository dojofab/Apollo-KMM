package com.example.apollo_kmm.repository

import com.example.apollo_kmm.model.Country
import com.example.apollo_kmm.model.CountryDetails
import com.example.apollo_kmm.utils.AsyncOperation
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    suspend fun getCountries(): Flow<AsyncOperation<List<Country>>>
    suspend fun getCountryDetails(countryCode: String): Flow<AsyncOperation<CountryDetails?>>
}