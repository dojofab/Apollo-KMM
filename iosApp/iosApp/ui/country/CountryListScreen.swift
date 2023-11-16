//
//  CountryListScreen.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CountryListScreen: View {
  
  @StateObject var viewModel = CountryViewModel()
  @State private var showDetails = false
  
  var body: some View {
    ZStack {
      
      if viewModel.isLoading {
        LoadingScreen()
      }
      
      if let error = viewModel.error {
        ErrorScreen(message: error.errorMessage)
      }
      
      ScrollView(.vertical, showsIndicators: false) {
        VStack(spacing: 0) {
          ForEach(viewModel.countries, id: \.code) { country in
            CountryItem(country: country)
              .onTapGesture {
                viewModel.onGetCountryDetails(countryCode: country.code)
                showDetails = true
              }
          }
        }
      }
    }
    .sheet(isPresented: $showDetails){
      if let countryDetails = viewModel.countryDetails {
        CountryDetailsScreen(countryDetails: countryDetails)
      }
    }
  }
}

struct CountryListScreen_Previews: PreviewProvider {
  static var previews: some View {
    CountryListScreen()
  }
}

