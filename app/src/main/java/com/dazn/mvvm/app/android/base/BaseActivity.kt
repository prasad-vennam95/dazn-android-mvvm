package com.dazn.mvvm.app.android.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import com.dazn.mvvm.presentation.theme.AppTheme

abstract class BaseActivity : ComponentActivity() {

    // Permission launcher
    private lateinit var permissionLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            onPermissionResult(isGranted)
        }
        // Set the content for the activity
        setContent {
            AppTheme {
                Content()
            }
        }
    }

    @Composable
    abstract fun Content()

    protected open fun requestPermission(permission: String) {
        permissionLauncher.launch(permission)
    }

    protected open fun onPermissionResult(isGranted: Boolean) {

    }

    protected inline fun <reified T : androidx.lifecycle.ViewModel> getViewModel(): T {
        return ViewModelProvider(this)[T::class.java]
    }
}