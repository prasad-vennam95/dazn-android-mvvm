package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomBar(progressOfSelectedSlide: Float) {

    Box(
        modifier = Modifier
            .width(56.dp)
            .height(8.dp)
    ) {
        // Background Bar (Inactive)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0x66F9FAFA),
                    shape = RoundedCornerShape(50)
                )
        )
        // Animated Progress Bar (Active)
        Box(
            modifier = Modifier
                .fillMaxHeight(progressOfSelectedSlide)
                .background(
                    color = Color(0xFFFFD700), // Replace with your primary active color
                    shape = RoundedCornerShape(50)
                )
        )
    }
}

