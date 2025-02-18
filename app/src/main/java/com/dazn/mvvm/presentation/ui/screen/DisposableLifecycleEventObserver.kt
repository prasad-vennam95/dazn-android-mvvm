package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.Job

@Composable
fun DisposableLifecycleEventObserver(
    onEvent: (LifecycleOwner, Lifecycle.Event) -> Unit,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycle = lifecycleOwner.lifecycle
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver(onEvent)
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}

@Composable
fun DisposableLifecycleEventObserver(
    event: Lifecycle.Event,
    job: Job? = null,
    onEvent: () -> Unit,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycle = lifecycleOwner.lifecycle
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, observerEvent ->
            if (observerEvent == event) onEvent()
        }
        lifecycle.addObserver(observer)
        onDispose {
            job?.cancel()
            lifecycle.removeObserver(observer)
        }
    }
}

@Composable
fun DisposableLifecycleEventObserver(
    observer: LifecycleEventObserver,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycle = lifecycleOwner.lifecycle
    DisposableEffect(lifecycleOwner, observer) {
        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}