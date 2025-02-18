package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AutoScrollCarousel(
    modifier: Modifier = Modifier,
    scrollInterval: Long,
    pagerState: PagerState,
    userScrollEnabled: Boolean = true,
    itemContent: @Composable (index: Int) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var lastInteractionTime by remember { mutableLongStateOf(System.currentTimeMillis()) }

    LaunchedEffect(lastInteractionTime) {
        while (true) {
            delay(scrollInterval)

            coroutineScope.launch {
                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                if (pagerState.currentPage == pagerState.pageCount - 1) {
                    pagerState.animateScrollToPage(0)
                } else {
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        userScrollEnabled = userScrollEnabled
    ) { pageIndex ->
        itemContent(pageIndex)
    }

    // Detect user swipe and reset auto-scroll timer
    LaunchedEffect(pagerState.isScrollInProgress) {
        if (pagerState.isScrollInProgress) {
            lastInteractionTime = System.currentTimeMillis()
        }
    }
}





