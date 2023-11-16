//
//  KotlinError.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/13/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class KotlinError: LocalizedError {
  let throwable: KotlinThrowable

  init(_ throwable: KotlinThrowable) {
    self.throwable = throwable
  }

  var errorDescription: String? {
    throwable.message
  }
}

extension KotlinThrowable {
  func asError() -> KotlinError {
    KotlinError(self)
  }
}
