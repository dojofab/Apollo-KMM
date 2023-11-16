package com.appsbeyond.countdownplus.shared.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

// Adapted from https://github.com/touchlab/KaMPKit/blob/main/shared/src/iosMain/kotlin/co/touchlab/kampkit/CoroutineAdapters.kt

fun <T : Any> Flow<T>.asSubscriber(scope: CoroutineScope): FlowSubscriber<T> =
    FlowSubscriber(scope = scope, this)

class FlowSubscriber<T : Any>(private val scope: CoroutineScope, private val flow: Flow<T>) {
    @Suppress("unused")
    fun subscribe(
        onEach: (T) -> Unit,
        onComplete: () -> Unit,
        onError: (Throwable) -> Unit
    ): Canceller = JobCanceller(
        flow.onEach { onEach(it) }
            .catch { onError(it) }
            .onCompletion { onComplete() }
            .launchIn(scope)
    )
}

interface Canceller {
    fun cancel()
}

private class JobCanceller(private val job: Job) : Canceller {
    override fun cancel() {
        job.cancel()
    }
}
