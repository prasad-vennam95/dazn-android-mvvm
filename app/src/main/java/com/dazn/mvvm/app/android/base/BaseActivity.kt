package com.dazn.mvvm.app.android.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import com.dazn.mvvm.presentation.theme.AppTheme

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Content()
            }
        }
    }

    @Composable
    abstract fun Content()

    protected inline fun <reified T : androidx.lifecycle.ViewModel> getViewModel(): T {
        return ViewModelProvider(this)[T::class.java]
    }
}