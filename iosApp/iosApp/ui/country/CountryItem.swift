//
//  CountryItem.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CountryItem: View {
  
  let country: Country
  
  var body: some View {
    HStack (spacing: 0) {
      Text(country.emoji)
        .font(.system(size: 30))
      
      Spacer()
        .frame(width: 10)
      
      VStack (alignment: .leading) {
        Text(country.name)
          .font(.system(size: 20))
        Text(country.capital)
          .foregroundStyle(.gray)
      }
    }
    .frame(maxWidth: .infinity, alignment: .leading)
    .padding(10)
  }
}


