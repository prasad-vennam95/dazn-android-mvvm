package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState.Content.LogoUiState
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState.Content.TextPriceData
import com.dazn.mvvm.presentation.theme.Asphalt

@Preview
@Composable
private fun ContentPreview() {
    Exit3ppPaywallScreen(
        uiState = Exit3ppPaywallUiState.Content(
            backgroundImage = "",
            logo = LogoUiState.Empty,
            title = "Upgrade for Higher Tier Content",
            subtitle = "Gain access to content X. Upgrade now and enjoy unparalleled live coverage, highlights and more.",
            dateTimeLabel = "10 Feb - 01:30",
            buttonText = "Get started",
            textWithPrice = TextPriceData(
                textBeforePrice = "From ",
                priceText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.LineThrough,
                            color = Asphalt,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("$20")
                    }
                    append(" $10")
                },
                textAfterPrice = " /month"
            ),
        ),
        onDismiss = {},
    )
}

@Composable
fun Exit3ppPaywallScreen(
    uiState: Exit3ppPaywallUiState,
    onDismiss: (Boolean) -> Unit,
) {
    when (uiState) {
        is Exit3ppPaywallUiState.Content -> {
            Exit3ppPaywallContent(
                uiState = uiState,
                onDismiss = onDismiss,
            )
        }

        is Exit3ppPaywallUiState.Initial -> CircularLoadingIndicator()
    }
}

@Composable
fun CircularLoadingIndicator(
    modifier: Modifier = Modifier,
    fillMaxSize: Boolean = true,
    color: Color = Color.White,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
            if (fillMaxSize) {
                modifier.fillMaxSize()
            } else {
                modifier
            }
    ) {
        CircularProgressIndicator(color = color)
    }
}