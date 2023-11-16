package com.example.apollo_kmm.utils

import com.example.apollo_kmm.CountriesQuery
import com.example.apollo_kmm.CountryQuery
import com.example.apollo_kmm.model.Country
import com.example.apollo_kmm.model.CountryDetails


fun CountryQuery.Country.toCountryDetails(): CountryDetails {
    return CountryDetails(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toCountry(): Country {
    return Country(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}