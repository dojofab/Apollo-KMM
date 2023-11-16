package com.example.apollo_kmm.data.network

import com.example.apollo_kmm.data.network.api.ApolloClient
import com.example.apollo_kmm.model.Country
import com.example.apollo_kmm.model.CountryDetails

class NetworkDataSourceImpl(
    private val apolloClient: ApolloClient
): NetworkDataSource {

    override suspend fun getCountries(): Result<List<Country>> = runCatching {
        return@runCatching apolloClient.getCountries()
    }

    override suspend fun getCountryDetails(countryCode: String): Result<CountryDetails?> = runCatching {
        return@runCatching apolloClient.getCountryDetails(countryCode)
    }
}