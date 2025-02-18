package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dazn.mvvm.R
import com.dazn.mvvm.data.model.OnboardingPage
import com.dazn.mvvm.data.model.onboardPages
import com.dazn.mvvm.presentation.theme.Chalk
import com.dazn.mvvm.presentation.theme.Mako
import com.dazn.mvvm.presentation.theme.size16
import com.dazn.mvvm.presentation.theme.size40
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingUI(
    list: List<OnboardingPage> = onboardPages
) {
    val pagerState = rememberPagerState(pageCount = { list.size })

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        AutoScrollCarousel(
            modifier = Modifier,
            itemContent = { page ->
                OnboardingScreen(page = onboardPages[page])
            },
            scrollInterval = 3000,
            pagerState = pagerState,
            userScrollEnabled = true,
        )
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .padding(size16)
                .size(size40)
                .align(Alignment.TopStart),
        )
        Row(
            modifier = Modifier
                .padding(size16)
                .align(Alignment.TopEnd), // Ensures it stays on top
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /* Handle Explore Click */ },
                shape = RoundedCornerShape(12),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Chalk
                ),
                modifier = Modifier
                    .height(38.dp)
            ) {
                Text(
                    text = "Explore",
                    color = Color.Black, // Text color as per Figma
                    style = MaterialTheme.typography.bodyMedium, // Ensure correct font style
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(
                onClick = { /* Handle Explore Click */ },
                shape = RoundedCornerShape(12),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Mako
                ),
                modifier = Modifier
                    .height(38.dp)
            ) {
                Text(
                    text = "Sign in",
                    color = Color.White, // Text color as per Figma
                    style = MaterialTheme.typography.bodyMedium, // Ensure correct font style
                )
            }
        }
        CirclePageIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
        ExpandingPagerIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            numberOfSlides = pagerState.pageCount,
            indexOfSelectedSlide = pagerState.currentPage,
            slideChangeInterval = 3.seconds
        )
    }
}


@Preview
@Composable
fun OnboardingUIPreview() {
    OnboardingUI()
}
