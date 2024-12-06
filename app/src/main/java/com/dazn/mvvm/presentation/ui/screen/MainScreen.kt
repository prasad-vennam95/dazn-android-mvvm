package com.dazn.mvvm.presentation.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dazn.mvvm.R
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.dazn.mvvm.presentation.ui.uistate.MainUiState
import com.dazn.mvvm.presentation.ui.viemodel.MainNavigationEvent
import com.dazn.mvvm.presentation.ui.viemodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val context = LocalContext.current
    val uiState by viewModel.uiStateFlow.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.eventFlow.collect { event ->
            when (event) {
                is MainNavigationEvent.NavigateToDetails -> {
                    Toast.makeText(context, "Navigating to Details", Toast.LENGTH_SHORT).show()
                }

                is MainNavigationEvent.ShowErrorDialog -> {
                    Toast.makeText(context, "Error occurred!", Toast.LENGTH_SHORT).show()
                }

                else -> Unit
            }
        }
    }

    MainContent(uiState, onNavigate = { viewModel.navigateToDetails() })
}

@Composable
fun MainContent(uiState: MainUiState, onNavigate: () -> Unit) {
    if (uiState.isLoading) {
        Column(
            Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource(id = R.drawable.ic_launcher_foreground),
                    null,
                    Modifier.align(Alignment.Center)
                )
                CircularProgressIndicator()
            }
        }
    } else {
        Column(
            Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally
        ) {
            Text(uiState.message)
            Button(onClick = onNavigate) {
                Text("Go to Details")
            }
        }
    }
}