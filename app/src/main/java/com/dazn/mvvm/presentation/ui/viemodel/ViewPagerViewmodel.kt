package com.dazn.mvvm.presentation.ui.viemodel

import com.dazn.mvvm.app.android.base.BaseViewModel
import com.dazn.mvvm.presentation.ui.events.CommonNavigationEvent
import com.dazn.mvvm.presentation.ui.events.ViewPagerNavigationEvent
import com.dazn.mvvm.presentation.ui.uistate.ViewPagerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewPagerViewmodel @Inject constructor() :
    BaseViewModel<ViewPagerUiState, ViewPagerNavigationEvent>(
        initialUiState = ViewPagerUiState()
    ) {
}