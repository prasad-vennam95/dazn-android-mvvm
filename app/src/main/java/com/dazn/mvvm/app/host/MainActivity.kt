@file:OptIn(ExperimentalMaterial3Api::class)

package com.dazn.mvvm.app.host

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.dazn.mvvm.app.android.base.BaseActivity
import com.dazn.mvvm.presentation.ui.screen.MainScreen
import com.dazn.mvvm.presentation.ui.viemodel.MainNavigationEvent
import com.dazn.mvvm.presentation.ui.viemodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        lifecycleScope.launch {
            mainViewModel.eventFlow.collectLatest { event ->
                when (event) {
                    is MainNavigationEvent.NavigateToDetails -> navigateToDetails()
                    is MainNavigationEvent.ShowErrorDialog -> showErrorDialog()
                    else -> Unit
                }
            }
        }
    }

    private fun navigateToDetails() {

    }

    private fun showErrorDialog() {

    }

    @Composable
    override fun Content() {
        mainViewModel.loadContent()
        MainScreen(mainViewModel)
    }

    companion object {
        const val TAG = "MainActivity"
    }
}