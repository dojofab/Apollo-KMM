package com.example.apollo_kmm.android.ui.country

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.apollo_kmm.domain.country.CountryViewModel
import com.example.apollo_kmm.model.Country
import com.example.apollo_kmm.model.CountryDetails
import com.example.apollo_kmm.utils.RepositoryError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryScreenModel @Inject constructor(): CountryViewModel() {

    var isLoading: Boolean by mutableStateOf(false)
        private set
    var error: RepositoryError? by mutableStateOf(null)
        private set
    var countries: List<Country> by mutableStateOf(emptyList())
        private set
    var countryDetails: CountryDetails? by mutableStateOf(null)
        private set

    init {
        viewModelScope.launch {
            stateFlow.collect {
                isLoading = it.isLoading
                error = it.error
                countries = it.countries
                countryDetails = it.countryDetails
            }
        }

        onGetCountries()
    }

    private fun onGetCountries() {
        getCountries()
    }

    fun onGetCountryDetails(countryCode: String) {
        getCountryDetails(countryCode)
    }
}