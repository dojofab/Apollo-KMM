package com.example.apollo_kmm.repository

import com.example.apollo_kmm.data.local.LocalDataSource
import com.example.apollo_kmm.data.network.NetworkDataSource
import com.example.apollo_kmm.utils.AsyncRequest

class CountryRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
): CountryRepository, AsyncRequest() {

    override suspend fun getCountries() = apiCall { networkDataSource.getCountries() }

    override suspend fun getCountryDetails(countryCode: String) = apiCall { networkDataSource.getCountryDetails(countryCode) }
}