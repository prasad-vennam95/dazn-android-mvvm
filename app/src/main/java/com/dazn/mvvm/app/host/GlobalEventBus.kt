package com.dazn.mvvm.app.host

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object GlobalEventBus {

    // A shared flow to emit events
    private val _eventFlow = MutableSharedFlow<GlobalEvent>(replay = 1)
    val eventFlow = _eventFlow.asSharedFlow()

    // Emit events to the flow
    suspend fun emitEvent(event: GlobalEvent) {
        _eventFlow.emit(event)
    }

    // Define different global events
    sealed class GlobalEvent {
        object UserLoggedIn : GlobalEvent()
        object UserLoggedOut : GlobalEvent()
        data class ThemeChanged(val isDarkMode: Boolean) : GlobalEvent()
        data class NetworkStatusChanged(val isConnected: Boolean) : GlobalEvent()
    }
}
