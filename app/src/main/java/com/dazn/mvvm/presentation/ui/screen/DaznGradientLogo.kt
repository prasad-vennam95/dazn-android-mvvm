package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode.Companion.SrcAtop
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.CompositingStrategy.Companion.Offscreen
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import com.dazn.mvvm.presentation.theme.Grey
import com.dazn.mvvm.presentation.theme.White
import com.dazn.mvvm.utils.Icon.*

@Composable
fun DaznGradientLogo(modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = LOGO.value),
        contentDescription = null,
        modifier = modifier
            .graphicsLayer { compositingStrategy = Offscreen }
            .drawWithCache {
                onDrawWithContent {
                    drawContent()
                    drawRect(
                        brush = linearGradient(
                            colors = listOf(White, Grey),
                            start = Offset.Zero,
                            end = Offset.Infinite,
                        ),
                        blendMode = SrcAtop,
                    )
                }
            },
    )
}