//
//  CountryDetailsScreen.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CountryDetailsScreen: View {
  
  let countryDetails: CountryDetails
  
  private var languages: String {
    return countryDetails.languages.joined(separator:",")
  }
  
  var body: some View {
    VStack (alignment: .leading) {
      
      HStack {
        Text(countryDetails.emoji)
          .font(.system(size: 30))
        Text(countryDetails.name)
          .font(.system(size: 24))
        
      }
      
      Spacer()
        .frame(height: 16)
      Text("Countinent: \(countryDetails.continent)")
      Spacer()
        .frame(height: 8)
      Text("Currency: \(countryDetails.currency)")
      Spacer()
        .frame(height: 8)
      Text("Capital: \(countryDetails.capital)")
      Spacer()
        .frame(height: 8)
      Text("Capital: \(languages)")
      Spacer()
        .frame(height: 8)
    }
    .frame(maxHeight: .infinity, alignment: .top)
    .padding(10)
  }
}

