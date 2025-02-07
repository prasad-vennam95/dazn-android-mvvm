@file:OptIn(ExperimentalMaterial3Api::class)

package com.dazn.mvvm.app.host

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.dazn.mvvm.app.android.base.BaseActivity
import com.dazn.mvvm.presentation.navigation.AppNavigation
import com.dazn.mvvm.presentation.ui.AppRoutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Composable
    override fun Content() {
        MyApp()
    }

    companion object {
        const val TAG = "MainActivity"
    }

    @Composable
    fun MyApp() {
        AppNavigation(
            startDestination = AppRoutes.Main,
        )
    }
}