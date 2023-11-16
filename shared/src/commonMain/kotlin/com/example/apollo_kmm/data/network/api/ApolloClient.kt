package com.example.apollo_kmm.data.network.api

import com.apollographql.apollo3.ApolloClient
import com.example.apollo_kmm.CountriesQuery
import com.example.apollo_kmm.CountryQuery
import com.example.apollo_kmm.utils.NetworkConfig
import com.example.apollo_kmm.model.Country
import com.example.apollo_kmm.model.CountryDetails
import com.example.apollo_kmm.utils.toCountry
import com.example.apollo_kmm.utils.toCountryDetails

class ApolloClient {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl(NetworkConfig.BASE_URL)
        .httpExposeErrorBody(true)
        .build()

    suspend fun getCountries(): List<Country> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toCountry() }
            ?: emptyList()
    }

    suspend fun getCountryDetails(countryCode: String): CountryDetails? {
         return apolloClient
             .query(CountryQuery(countryCode))
             .execute()
             .data
             ?.country
             ?.toCountryDetails()
    }
}