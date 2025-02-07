package com.dazn.mvvm.presentation.ui.events;

sealed class MainNavigationEvent : CommonNavigationEvent() {
    object NavigateToViewPager : MainNavigationEvent()
}