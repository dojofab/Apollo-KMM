//
//  CancelBag.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/13/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Combine

final class CancelBag {
  // swiftlint:disable:next strict_fileprivate
  fileprivate(set) var subscriptions = Set<AnyCancellable>()

  func cancel() {
    subscriptions.removeAll()
  }

  func insert(_ cancellables: AnyCancellable...) {
    subscriptions.formUnion(cancellables)
  }

  func insert(_ cancellables: [AnyCancellable]) {
    subscriptions.formUnion(cancellables)
  }
}

extension AnyCancellable {
  func store(in cancelBag: CancelBag) {
    cancelBag.subscriptions.insert(self)
  }
}
