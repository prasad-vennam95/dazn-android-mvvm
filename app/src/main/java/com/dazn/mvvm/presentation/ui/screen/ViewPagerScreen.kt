package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.dazn.mvvm.presentation.ui.AppRoutes
import com.dazn.mvvm.presentation.ui.events.ViewPagerNavigationEvent
import com.dazn.mvvm.presentation.ui.viemodel.ViewPagerViewmodel
import com.dazn.mvvm.utils.MessageUtils.showToastMessage

@Composable
fun ViewpagerScreen(
    viewModel: ViewPagerViewmodel,
    navController: NavController
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.eventFlow.collect { event ->
            when (event) {
                is ViewPagerNavigationEvent.NavigateToMain -> {
                    navController.navigate(AppRoutes.Main.name)
                }

                is ViewPagerNavigationEvent.ShowErrorDialog -> {
                    context.showToastMessage("Error occurred")
                }

                else -> Unit
            }
        }
    }

    ViewpagerContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewpagerContent() {
    Scaffold { innerPadding ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            OnboardingUI()
        }
    }
}
