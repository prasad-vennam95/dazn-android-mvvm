package com.dazn.mvvm.presentation.ui.events

sealed class ViewPagerNavigationEvent {
    object NavigateToMain : ViewPagerNavigationEvent()
    object ShowErrorDialog : ViewPagerNavigationEvent()
}