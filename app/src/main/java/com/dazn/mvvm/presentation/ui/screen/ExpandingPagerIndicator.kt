package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dazn.mvvm.presentation.theme.Chalk
import com.dazn.mvvm.presentation.theme.Mako
import com.dazn.mvvm.presentation.theme.size10
import com.dazn.mvvm.presentation.theme.size32
import com.dazn.mvvm.presentation.theme.size8
import kotlin.time.Duration


@Composable
fun ExpandingPagerIndicator(
    modifier: Modifier = Modifier,
    numberOfSlides: Int,
    indexOfSelectedSlide: Int,
    slideChangeInterval: Duration,
) {
    val progressOfSelectedSlide = remember { Animatable(0f) }

    LaunchedEffect(indexOfSelectedSlide) {
        progressOfSelectedSlide.snapTo(0f)
        progressOfSelectedSlide.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = slideChangeInterval.inWholeMilliseconds.toInt(),
                easing = LinearEasing
            ),
        )
    }

    ExpandingPagerIndicatorContent(
        modifier = modifier,
        numberOfSlides = numberOfSlides,
        indexOfSelectedSlide = indexOfSelectedSlide,
        progressOfSelectedSlide = progressOfSelectedSlide.value,
    )
}

@Composable
fun ExpandingPagerIndicatorContent(
    modifier: Modifier = Modifier,
    numberOfSlides: Int,
    indexOfSelectedSlide: Int,
    progressOfSelectedSlide: Float,
) {
    if (numberOfSlides <= 1) return

    Row(
        modifier = modifier.padding(size10),
        horizontalArrangement = Arrangement.spacedBy(size8),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(numberOfSlides) { index ->
            if (index == indexOfSelectedSlide) {
                Bar(progressOfSelectedSlide)
            } else {
                Dot()
            }
        }
    }
}

@Composable
private fun Bar(fillFraction: Float) {
    Box(
        modifier = Modifier
            .width(size32)
            .height(size8),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Mako,
                    shape = RoundedCornerShape(50)
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = fillFraction)
                .fillMaxHeight()
                .background(
                    color = Chalk,
                    shape = RoundedCornerShape(50)
                )
        )
    }
}


@Composable
private fun Dot() {
    Box(
        modifier = Modifier
            .size(size8)
            .background(
                color = Chalk, shape = CircleShape
            )
    )
}

