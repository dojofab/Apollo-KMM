//
//  CombineAdapters.swift
//  iosApp
//
//  Created by Donn Johnson Fabian on 11/13/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Combine
import shared

// Adapted from https://github.com/touchlab/KaMPKit/blob/main/ios/KaMPKitiOS/CombineAdapters.swift

/// Create a Combine publisher from the supplied `FlowAdapter`. Use this in contexts where more transformation will be
/// done on the Swift side before the value is bound to UI
func createPublisher<T>(_ flowSubscriber: FlowSubscriber<T>) -> AnyPublisher<T, KotlinError> {
  Deferred<Publishers.HandleEvents<PassthroughSubject<T, KotlinError>>> {
    let subject = PassthroughSubject<T, KotlinError>()
    let canceller = flowSubscriber.subscribe(
      onEach: { subject.send($0) },
      onComplete: { subject.send(completion: .finished) },
      onError: { subject.send(completion: .failure($0.asError())) }
    )

    // swiftlint:disable:next trailing_closure
    return subject.handleEvents(receiveCancel: { canceller.cancel() })
  }
    .eraseToAnyPublisher()
}

/// Prepare the supplied `FlowSubscriber` to be bound to UI. The `onEach` callback will be called from `DispatchQueue.main`
/// on every new emission.
///
/// Note that this calls `assertNoFailure()` internally so you should handle errors upstream to avoid crashes.
func publishFlow<T>(_ flowSubscriber: FlowSubscriber<T>, onEach: @escaping (T) -> Void) -> AnyCancellable {
  createPublisher(flowSubscriber)
    .assertNoFailure()
    .compactMap { $0 }
    .receive(on: DispatchQueue.main)
    .sink { onEach($0) }
}
