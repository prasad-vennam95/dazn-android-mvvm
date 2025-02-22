package com.dazn.mvvm.presentation.ui.uistate

import com.dazn.mvvm.presentation.ui.UiState

data class MainUiState(
    val isLoading: Boolean = false,
    val message: String = ""
) : UiState