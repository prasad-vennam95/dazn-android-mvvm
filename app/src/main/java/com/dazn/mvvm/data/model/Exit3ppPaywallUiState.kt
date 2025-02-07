package com.dazn.mvvm.data.model

import com.dazn.mvvm.R
import androidx.annotation.DrawableRes
import androidx.compose.ui.text.AnnotatedString

sealed interface Exit3ppPaywallUiState {

    data class Content(
        val backgroundImage: String?,
        val logo: LogoUiState,
        val title: String,
        val subtitle: String,
        val dateTimeLabel: String?,
        val textWithPrice: TextPriceData?,
        val buttonText: String,
        val buttonEnabled: Boolean = true,
    ) : Exit3ppPaywallUiState {

        sealed interface LogoUiState {

            data class SingleLogo(
                val logoUrl: String,
            ) : LogoUiState

            data class LogoWithDaznLogo(
                val logoUrl: String,
                @DrawableRes val daznLogo: Int = R.drawable.ic_launcher_foreground,
            ) : LogoUiState

            object Empty : LogoUiState
        }

        data class TextPriceData(
            val textBeforePrice: String,
            val priceText: AnnotatedString,
            val textAfterPrice: String
        )
    }

    object Initial : Exit3ppPaywallUiState
}