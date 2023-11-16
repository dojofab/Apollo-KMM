//
//  CountryViewModel.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared
import Factory

class CountryViewModel: ObservableObject {
  
  @Published var isLoading: Bool = false
  @Published var error: RepositoryError? = nil
  @Published var countries: [Country] = []
  @Published var countryDetails: CountryDetails? = nil
  
  private var viewModel: CountryViewModelIos?
  private var cancelBag = CancelBag()
  
  init() {
    let viewModel = CountryViewModelIos()

    // Subscribe to view model changes
    cancelBag.insert(
      publishFlow(viewModel.stateSubscriber) { [weak self] state in
        self?.isLoading = state.isLoading
        self?.error = state.error
        self?.countries = state.countries
        self?.countryDetails = state.countryDetails
      }
    )

    self.viewModel = viewModel
    
    onGetCountries()
  }

  func onGetCountries() {
    viewModel?.getCountries()
  }
  
  func onGetCountryDetails(countryCode: String) {
    viewModel?.getCountryDetails(countryCode: countryCode)
  }
}
