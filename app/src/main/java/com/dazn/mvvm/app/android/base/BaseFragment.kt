package com.dazn.mvvm.app.android.base

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dazn.mvvm.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    private var onPermissionResult: ((Boolean) -> Unit)? = null

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            onPermissionResult?.invoke(isGranted)
        }

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    Content()
                }
            }
        }
    }

    @Composable
    abstract fun Content()

    fun requestPermission(permission: String, onResult: (Boolean) -> Unit) {
        onPermissionResult = onResult
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                requireContext().checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED -> {
                    onResult(true) // Permission already granted
                }

                shouldShowRequestPermissionRationale(permission) -> {
                    showPermissionRationale(permission, onResult)
                }

                else -> {
                    requestPermissionLauncher.launch(permission)
                }
            }
        }
    }

    protected open fun showPermissionRationale(permission: String, onResult: (Boolean) -> Unit) {
        requestPermissionLauncher.launch(permission)
    }

    protected inline fun <reified T : ViewModel> getFragmentViewModel(): T {
        return ViewModelProvider(this)[T::class.java]
    }

    protected inline fun <reified T : ViewModel> getActivityViewModel(): T {
        return ViewModelProvider(requireActivity())[T::class.java]
    }
}

