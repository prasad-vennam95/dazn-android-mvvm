package com.dazn.mvvm.app.host


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

class NavigationHost(
    private val startDestination: String,
    private val buildRoutes: (NavHostController) -> Unit
) {

    @Composable
    fun Host(modifier: Modifier = Modifier) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
        ) {
            buildRoutes(navController)
        }
    }
}
