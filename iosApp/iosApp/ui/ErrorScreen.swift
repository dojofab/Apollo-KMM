//
//  ErrorScreen.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ErrorScreen: View {
  
  let message: String
  
  var body: some View {
    Text(message)
  }
}

struct ErrorScreen_Previews: PreviewProvider {
  static var previews: some View {
    ErrorScreen(message: "Test")
  }
}
