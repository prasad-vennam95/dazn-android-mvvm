package com.dazn.mvvm.presentation.ui.events

sealed class CommonNavigationEvent : CommonErrorEvent() {
    data class BackToPreviousScreen(val route: String? = null) : CommonNavigationEvent()
    object NetWorkErrorMessageScreen : CommonNavigationEvent()
    object UserDetailedMessage : CommonNavigationEvent()
    object BackToMainScreen : CommonNavigationEvent()
    object BackToLoginScreen : CommonNavigationEvent()
    object BackToSplashScreen : CommonNavigationEvent()
    object BackToOnBoardingScreen : CommonNavigationEvent()
    object BackToHomeScreen : CommonNavigationEvent()
    object BackToProfileScreen : CommonNavigationEvent()
    object BackToNotificationScreen : CommonNavigationEvent()
    object BackToSettingsScreen : CommonNavigationEvent()
    object BackToHelpScreen : CommonNavigationEvent()
    object BackToAboutScreen : CommonNavigationEvent()
    object BackToContactScreen : CommonNavigationEvent()
    object MoveToNextScreen : CommonNavigationEvent()
    object MoveToChromePage : CommonNavigationEvent()
    object MoveToCustomWebPage : CommonNavigationEvent()
    object MoveToAppSettingsScreen : CommonNavigationEvent()
    object MoveToPlayStoreScreen : CommonNavigationEvent()
}

sealed class CommonErrorEvent {
    object NetWorkErrorMessageScreen : CommonNavigationEvent()
    object UserDetailedMessage : CommonNavigationEvent()
}