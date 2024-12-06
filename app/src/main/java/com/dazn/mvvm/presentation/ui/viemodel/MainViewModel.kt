package com.dazn.mvvm.presentation.ui.viemodel

import androidx.lifecycle.viewModelScope
import com.dazn.mvvm.app.android.base.BaseViewModel
import com.dazn.mvvm.presentation.ui.uistate.MainUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class MainNavigationEvent {
    object NavigateToDetails : MainNavigationEvent()
    object ShowErrorDialog : MainNavigationEvent()
}

class MainViewModel : BaseViewModel<MainUiState, MainNavigationEvent>(
    initialUiState = MainUiState()
) {

    fun loadContent() {
        updateUiState { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                delay(1000)
                updateUiState { it.copy(isLoading = false, message = "Data loaded successfully") }
            } catch (e: Exception) {
                updateUiState { it.copy(isLoading = false, message = "Error loading data") }
                pushEvent(MainNavigationEvent.ShowErrorDialog)
            }
        }
    }

    fun navigateToDetails() {
        pushEvent(MainNavigationEvent.NavigateToDetails)
    }
}