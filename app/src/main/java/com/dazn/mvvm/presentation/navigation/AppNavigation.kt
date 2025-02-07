package com.dazn.mvvm.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dazn.mvvm.presentation.ui.AppRoutes
import com.dazn.mvvm.presentation.ui.screen.MainScreen
import com.dazn.mvvm.presentation.ui.screen.ViewpagerScreen
import com.dazn.mvvm.presentation.ui.viemodel.MainViewModel
import com.dazn.mvvm.presentation.ui.viemodel.ViewPagerViewmodel

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
            val viewModel = MainViewModel()
            MainScreen(viewModel = viewModel, navController = navController)
        }

        composable(AppRoutes.ViewPager.name) {
            val viewModel = ViewPagerViewmodel()
            ViewpagerScreen(viewModel = viewModel, navController = navController)
        }
    }
}