package com.example.apollo_kmm.data.network

import com.example.apollo_kmm.model.Country
import com.example.apollo_kmm.model.CountryDetails

interface NetworkDataSource {
    suspend fun getCountries(): Result<List<Country>>
    suspend fun getCountryDetails(countryCode: String): Result<CountryDetails?>
}