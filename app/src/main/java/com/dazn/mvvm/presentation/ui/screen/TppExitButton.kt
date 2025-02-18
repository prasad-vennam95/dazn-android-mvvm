package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.dazn.common.compose.mobile.theme.daznMobileTypography
import com.dazn.mvvm.presentation.theme.size52
import com.dazn.mvvm.presentation.theme.size8

@Composable
fun TppExitButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    cornerSize: Dp = size8,
    enabled: Boolean = true,
    loading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(size52)
            .fillMaxWidth(),
        shape = RoundedCornerShape(cornerSize),
        enabled = enabled,
    ) {
        if (loading)
            CircularProgressIndicator()
        else
            Text(
                text = text,
                style = daznMobileTypography.daznButton.copy(),
            )
    }
}

@Preview
@Composable
private fun TppExitButtonPreview() {
    TppExitButton(
        onClick = {},
        text = "Get started",
    )
}

@Preview
@Composable
private fun TppExitButtonLoadingPreview() {
    TppExitButton(
        onClick = {},
        text = "Get started",
        loading = true,
    )
}

@Preview
@Composable
private fun TppExitButtonDisabledPreview() {
    TppExitButton(
        onClick = {},
        text = "Get started",
        enabled = false,
    )
}