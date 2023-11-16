package com.example.apollo_kmm.domain.country

import com.example.apollo_kmm.domain.ViewModel
import com.example.apollo_kmm.model.Country
import com.example.apollo_kmm.model.CountryDetails
import com.example.apollo_kmm.repository.CountryRepository
import com.example.apollo_kmm.utils.AsyncError
import com.example.apollo_kmm.utils.AsyncOperation
import com.example.apollo_kmm.utils.RepositoryError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

data class CountryState(
    val isLoading: Boolean = false,
    val error: RepositoryError? = null,
    val countries: List<Country> = emptyList(),
    val countryDetails: CountryDetails? = null
)

open class CountryViewModel: ViewModel(), KoinComponent {

    private val countryRepository: CountryRepository by inject()

    private val mutableStateFlow = MutableStateFlow(CountryState())
    val stateFlow = mutableStateFlow.asStateFlow()
    private val state
        get() = mutableStateFlow.value

    fun getCountries() {
        viewModelScope.launch {
            countryRepository.getCountries().collect { asyncOperation ->
                when(asyncOperation) {
                    is AsyncOperation.Loading -> { mutableStateFlow.update { it.copy(isLoading = true) } }
                    is AsyncOperation.Loaded -> { mutableStateFlow.update {
                        it.copy(countries = asyncOperation.value!!, isLoading = false) }
                    }
                    is AsyncOperation.Failed -> { mutableStateFlow.update {
                        it.copy(error = AsyncError.getRepositoryError(asyncOperation.error), isLoading = false) }
                    }
                }
            }
        }
    }

    fun getCountryDetails(countryCode: String) {
        viewModelScope.launch {
            countryRepository.getCountryDetails(countryCode).collect { asyncOperation ->
                when(asyncOperation) {
                    is AsyncOperation.Loading -> { mutableStateFlow.update { it.copy(isLoading = true) } }
                    is AsyncOperation.Loaded -> { mutableStateFlow.update {
                        it.copy(countryDetails = asyncOperation.value, isLoading = false) }
                    }
                    is AsyncOperation.Failed -> { mutableStateFlow.update {
                        it.copy(error = AsyncError.getRepositoryError(asyncOperation.error), isLoading = false) }
                    }
                }
            }
        }
    }
}