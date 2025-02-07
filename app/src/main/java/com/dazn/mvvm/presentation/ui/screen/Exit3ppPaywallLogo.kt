package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.dazn.mvvm.presentation.theme.size24
import com.dazn.mvvm.presentation.theme.size32
import com.dazn.mvvm.presentation.theme.size56
import com.dazn.mvvm.presentation.theme.size8
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState.Content.LogoUiState
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState.Content.LogoUiState.Empty
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState.Content.LogoUiState.LogoWithDaznLogo
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState.Content.LogoUiState.SingleLogo
import com.dazn.mvvm.presentation.theme.Iron
import com.dazn.mvvm.presentation.theme.size1
import com.dazn.mvvm.presentation.theme.size16

@Composable
fun Exit3ppPaywallLogo(
    logoUiState: LogoUiState,
) {
    when (logoUiState) {
        is SingleLogo -> {
            LogoAsyncImage(
                imgUrl = logoUiState.logoUrl,
                modifier = Modifier.padding(vertical = size16)
            )
        }

        is LogoWithDaznLogo -> {
            Row(
                modifier = Modifier
                    .padding(vertical = size16)
                    .height(size32)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                LogoAsyncImage(imgUrl = logoUiState.logoUrl)

                Box(
                    modifier = Modifier
                        .padding(horizontal = size8)
                        .size(width = size1, height = size24)
                        .background(color = Iron)
                )

                DaznGradientLogo(modifier = Modifier.size(size24))
            }
        }

        is Empty -> {
            DaznGradientLogo(
                modifier = Modifier
                    .padding(vertical = size16)
                    .size(size56),
            )
        }
    }
}


@Composable
private fun LogoAsyncImage(imgUrl: String, modifier: Modifier = Modifier) {
    DaznAsyncImage(
        imageUrl = imgUrl,
        withCrossFade = false,
        modifier = modifier.height(size32),
        contentScale = ContentScale.Fit,
    )
}