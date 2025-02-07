package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.dazn.mvvm.presentation.ui.AppRoutes
import com.dazn.mvvm.presentation.ui.events.MainNavigationEvent
import com.dazn.mvvm.presentation.ui.viemodel.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.eventFlow.collect { event ->
            when (event) {
                is MainNavigationEvent.NavigateToViewPager -> {
                    navController.navigate(AppRoutes.ViewPager.name)
                }

                else -> Unit
            }
        }
    }
    MainContent(viewModel)
}

@Composable
fun MainContent(viewModel: MainViewModel) {
    Column(
        Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            viewModel.navigateToViewPager()
        }) {
            Text("Go to ViewPager")
        }
    }
}

