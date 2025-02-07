package com.dazn.mvvm.presentation.ui.viemodel

import com.dazn.mvvm.app.android.base.BaseViewModel
import com.dazn.mvvm.presentation.ui.events.MainNavigationEvent
import com.dazn.mvvm.presentation.ui.uistate.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainUiState, MainNavigationEvent>(
    initialUiState = MainUiState()
) {
    fun navigateToViewPager() {
        pushEvent(MainNavigationEvent.NavigateToViewPager)
    }
}