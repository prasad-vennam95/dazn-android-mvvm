package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dazn.mvvm.R
import com.dazn.mvvm.data.model.onboardPages
import com.dazn.mvvm.presentation.theme.Chalk
import com.dazn.mvvm.presentation.theme.Mako
import com.dazn.mvvm.presentation.theme.size16
import com.dazn.mvvm.presentation.theme.size40
import com.dazn.mvvm.presentation.theme.withScreenDensity
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingUI() {
    val pagerState = rememberPagerState(
        pageCount = { 4 }
    )

    // Variable to track the user's scroll distance
    var userScrolled = remember { mutableIntStateOf(0) }

    // Detect the current page index and update `userScrolled`
    LaunchedEffect(pagerState.currentPage) {
        // If user scrolls 1 or 2 pages, adjust accordingly
        userScrolled.intValue = pagerState.currentPage
    }

    // Auto-slide effect with customized behavior based on user scroll
    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000L) // 3 seconds delay before moving to the next page

            // Adjust next page based on user scroll behavior
            val nextPage = when (userScrolled.intValue) {
                0 -> 1  // If the user just scrolled to 0th page, go to the 1st page
                1 -> 2  // If the user scrolled 1 page, go to the 2nd page
                2 -> 3  // If the user scrolled 2 pages, go to the last page
                else -> 0 // If on the last page, go to the first page
            }

            // Scroll to the next page, ensuring we loop back to the first page if necessary
            pagerState.animateScrollToPage(nextPage % pagerState.pageCount)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        ) { page ->
            OnboardingScreen(page = onboardPages[page])
        }
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
        PageIndicator(
            activeColor = Chalk,
            inactiveColor = Mako,
            pageCount = onboardPages.size,
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}


@Composable
internal fun PageIndicator(
    modifier: Modifier = Modifier,
    activeColor: Color,
    inactiveColor: Color,
    pageCount: Int,
    pagerState: PagerState,
) {
    val currentPageIndex = pagerState.currentPage
    val totalPages = pageCount
    if (currentPageIndex >= totalPages || totalPages == 1) return
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp.withScreenDensity()))
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp.withScreenDensity()),
            modifier = Modifier.padding(
                horizontal = 10.dp.withScreenDensity(),
                vertical = 5.dp.withScreenDensity()
            )
        ) {
            repeat(totalPages) { index ->
                val backgroundColor = if (index == currentPageIndex) activeColor else inactiveColor
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(16.dp.withScreenDensity())
                        .background(backgroundColor)
                )
            }
        }
    }
}


@Preview
@Composable
fun OnboardingUIPreview() {
    OnboardingUI()
}
