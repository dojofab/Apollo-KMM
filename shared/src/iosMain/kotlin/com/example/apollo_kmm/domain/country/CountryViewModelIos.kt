package com.example.apollo_kmm.domain.country

import com.appsbeyond.countdownplus.shared.coroutines.asSubscriber

class CountryViewModelIos : CountryViewModel() {
    val stateSubscriber = this.stateFlow.asSubscriber(scope = this.viewModelScope)
}