package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dazn.mvvm.data.model.onboardPages
import com.google.accompanist.pager.HorizontalPagerIndicator

@Composable
fun OnboardingUI() {
    val pagerState = rememberPagerState(
        pageCount = { 4 }
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Skip ",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 270.dp, top = 24.dp)
                .clickable { })

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            OnboardingScreen(page = onboardPages[page])
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 10.dp)
        ) {
            HorizontalPagerIndicator(
                activeColor = Color.Green,
                inactiveColor = Color.White,
                pageCount = onboardPages.size,
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable {

                    }

            )
        }

        AnimatedVisibility(visible = pagerState.currentPage == 3) {
            OutlinedButton(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 24.dp, top = 14.dp, end = 24.dp, bottom = 8.dp),
                onClick = {},
            ) {
                Text(
                    text = "Let's Start",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}