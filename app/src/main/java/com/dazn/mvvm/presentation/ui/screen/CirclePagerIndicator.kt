package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.dazn.mvvm.presentation.theme.Chalk
import com.dazn.mvvm.presentation.theme.GlovesLight
import com.dazn.mvvm.presentation.theme.Mako
import com.dazn.mvvm.presentation.theme.size10
import com.dazn.mvvm.presentation.theme.size8

@Composable
internal fun CirclePageIndicator(
    modifier: Modifier = Modifier,
    activeColor: Color = Chalk,
    inactiveColor: Color = Mako,
    indicatorSize: Dp = size8,
    indicatorSpacing: Dp = size8,
    pagerState: PagerState,
    paddingValues: PaddingValues = PaddingValues(horizontal = size8, vertical = size8),
) {
    val currentPageIndex = pagerState.currentPage
    val totalPages = pagerState.pageCount

    if (currentPageIndex >= totalPages || totalPages == 1) return

    Box(
        modifier = modifier
            .padding(paddingValues)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(indicatorSpacing),
        ) {
            repeat(totalPages) { index ->
                val animatedBackgroundColor by animateColorAsState(
                    targetValue = if (index == currentPageIndex) activeColor else inactiveColor
                )
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(indicatorSize)
                        .background(animatedBackgroundColor)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CirclePageIndicatorPreview() {
    val pagerState = rememberPagerState(pageCount = { 4 })

    CirclePageIndicator(
        activeColor = Mako,
        inactiveColor = GlovesLight,
        pagerState = pagerState,
        indicatorSize = size8,
        indicatorSpacing = size10,
        paddingValues = PaddingValues(horizontal = size8, vertical = size8),
    )
}



