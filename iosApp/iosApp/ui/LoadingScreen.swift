//
//  LoadingScreen.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/8/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct LoadingScreen: View {
  
  var body: some View {
    VStack {
      ProgressView()
      .progressViewStyle(CircularProgressViewStyle())
    }
  }
}

struct LoadingScreen_Previews: PreviewProvider {
  static var previews: some View {
    LoadingScreen()
  }
}
