package com.dazn.mvvm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dazn.mvvm.presentation.ui.AppRoutes
import com.dazn.mvvm.presentation.ui.screen.OnboardingUI

@Composable
fun <T : Enum<T>> AppNavigation(
    startDestination: T,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination.name
    ) {
        composable(AppRoutes.Main.name) {
            OnboardingUI()
        }

        composable(AppRoutes.ViewPager.name) {
            
        }
    }
}