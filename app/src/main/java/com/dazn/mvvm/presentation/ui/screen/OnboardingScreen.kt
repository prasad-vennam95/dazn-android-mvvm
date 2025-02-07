package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dazn.mvvm.data.model.OnboardingPage

@Composable
fun OnboardingScreen(page: OnboardingPage) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize() // Make Box occupy the entire screen
    ) {
        // Background Image - Fills Entire Screen
        Image(
            painter = painterResource(id = page.image),
            contentDescription = "Step Number",
            contentScale = ContentScale.Crop, // Ensures the image covers the screen
            modifier = Modifier
                .fillMaxSize() // Fills the entire screen
        )

        // Content Overlay
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp), // Add some padding to avoid content touching edges
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom // Push content towards bottom
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = page.title,
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (page.stepNumber != 4) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(40.dp),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = page.background),
                    modifier = Modifier
                        .size(64.dp) // Ensures the button is a perfect circle
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Next",
                        tint = Color.White
                    )
                }
            }
        }
    }
}