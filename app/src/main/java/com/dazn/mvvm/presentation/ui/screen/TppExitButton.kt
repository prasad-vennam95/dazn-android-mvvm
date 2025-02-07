package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.dazn.common.compose.mobile.theme.daznMobileTypography
import com.dazn.mvvm.presentation.theme.Asphalt
import com.dazn.mvvm.presentation.theme.Chalk
import com.dazn.mvvm.presentation.theme.Ebony
import com.dazn.mvvm.presentation.theme.Smoky
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
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = Chalk,
        disabledBackgroundColor = Ebony,
        contentColor = Smoky,
        disabledContentColor = Asphalt,
    ),
) {
    val contentColor by colors.contentColor(enabled)
    Button(
        onClick = onClick,
        modifier = modifier
            .height(size52)
            .fillMaxWidth(),
        colors = colors,
        shape = RoundedCornerShape(cornerSize),
        enabled = enabled,
    ) {
        if (loading)
            CircularProgressIndicator(color = contentColor)
        else
            Text(
                text = text,
                style = daznMobileTypography.daznButton.copy(color = contentColor),
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