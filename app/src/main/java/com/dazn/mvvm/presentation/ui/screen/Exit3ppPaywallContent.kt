package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dazn.common.compose.mobile.theme.daznMobileTypography
import com.dazn.mvvm.R
import com.dazn.mvvm.data.model.Exit3ppPaywallUiState
import com.dazn.mvvm.presentation.theme.Brick
import com.dazn.mvvm.presentation.theme.Iron
import com.dazn.mvvm.presentation.theme.Mako
import com.dazn.mvvm.presentation.theme.Tarmac100
import com.dazn.mvvm.presentation.theme.White
import com.dazn.mvvm.presentation.theme.size10
import com.dazn.mvvm.presentation.theme.size16
import com.dazn.mvvm.presentation.theme.size18
import com.dazn.mvvm.presentation.theme.size2
import com.dazn.mvvm.presentation.theme.size32
import com.dazn.mvvm.presentation.theme.size38
import com.dazn.mvvm.presentation.theme.size380
import com.dazn.mvvm.presentation.theme.size84
import com.dazn.mvvm.utils.Icon

@Composable
fun Exit3ppPaywallContent(
    uiState: Exit3ppPaywallUiState.Content,
    onDismiss: (Boolean) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        AsyncImage(
            model = uiState.backgroundImage,
            contentDescription = stringResource(id = R.string.background_image),
            modifier = Modifier
                .matchParentSize()
                .background(Tarmac100),
            contentScale = ContentScale.Crop,
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.leagues_logo),
            modifier = Modifier
                .padding(size10)
                .size(size38)
                .align(Alignment.TopStart),
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(size10)
        ) {
            Icon(
                painter = painterResource(Icon.CLOSE.value),
                contentDescription = stringResource(id = R.string.back_button),
                tint = Color.White,
                modifier = Modifier
                    .width(72.dp)
                    .height(28.dp)
                    .background(Mako)

            )
            Spacer(modifier = Modifier.padding(size10))
            Icon(
                painter = painterResource(Icon.CLOSE.value),
                contentDescription = stringResource(id = R.string.back_button),
                tint = Color.White,
                modifier = Modifier
                    .width(72.dp)
                    .height(28.dp)
                    .background(Mako)
            )
        }

        Column(
            modifier = Modifier
                .widthIn(max = size380)
                .padding(size16)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Paywall(uiState)
        }
    }
}

@Composable
private fun Paywall(uiState: Exit3ppPaywallUiState.Content) {
    Exit3ppPaywallLogo(logoUiState = uiState.logo)
    DateTimeLabel(uiState = uiState)
    Spacer(modifier = Modifier.height(size10))
    Text(
        text = uiState.title,
        style = daznMobileTypography.header4Regular,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = uiState.subtitle,
        style = daznMobileTypography.chalkTrim14,
        textAlign = TextAlign.Center,
        color = Iron,
        modifier = Modifier.padding(top = size16)
    )
    uiState.textWithPrice?.let { textData ->
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = size16),
        ) {
            Text(
                text = textData.textBeforePrice,
                style = daznMobileTypography.body2Regular,
            )
            Text(
                text = textData.priceText,
                style = daznMobileTypography.oscine20Bold,
            )
            Text(
                text = textData.textAfterPrice,
                style = daznMobileTypography.body2Regular,
            )
        }
    } ?: Spacer(modifier = Modifier.height(size32))
}

@Composable
internal fun DateTimeLabel(
    uiState: Exit3ppPaywallUiState.Content,
) {
    if (uiState.dateTimeLabel.isNullOrEmpty().not()) {
        Box(
            modifier = Modifier
                .background(color = White, shape = RoundedCornerShape(size2))
                .defaultMinSize(minHeight = size18, minWidth = size84),
        ) {
            Text(
                color = Tarmac100,
                text = uiState.dateTimeLabel,
                style = daznMobileTypography.body3Bold,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}
