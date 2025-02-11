package com.dazn.mvvm.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dazn.mvvm.R
import com.dazn.mvvm.data.model.OnboardingPage
import com.dazn.mvvm.data.model.VideoConfig
import com.dazn.mvvm.presentation.theme.Black
import com.dazn.mvvm.presentation.theme.size1
import com.dazn.mvvm.presentation.theme.size12
import com.dazn.mvvm.presentation.theme.size3
import com.dazn.mvvm.presentation.theme.size4
import com.dazn.mvvm.presentation.theme.size48
import com.dazn.mvvm.presentation.theme.size8

@Composable
fun OnboardingScreen(page: OnboardingPage) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize() // Make Box occupy the entire screen
    ) {
        // Background Image - Fills Entire Screen
        page.backgroundImage?.let {
            DaznAsyncImage(
                imageUrl = it,
                withCrossFade = false,
                modifier = Modifier.fillMaxHeight(),
                contentScale = ContentScale.Crop,
            )
        }

        // Content Overlay
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            if (page.logos?.isNotEmpty() == true) {
                if (page.logos.size == 1) {
                    Box(
                        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                    ) {
                        DaznAsyncImage(
                            imageUrl = page.logos.first(),
                            withCrossFade = false,
                            modifier = Modifier.height(size48), // Adjust width for a single logo
                            contentScale = ContentScale.Inside,
                        )
                    }
                } else {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(size12)
                    ) {
                        page.logos.forEach { logo ->
                            DaznAsyncImage(
                                imageUrl = logo,
                                withCrossFade = false,
                                modifier = Modifier.height(size48), // Adjust width for a single logo
                                contentScale = ContentScale.Inside,
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .background(
                        Color.White, shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                page.dateAndTime?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelMedium.copy(color = Black)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            page.title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            page.subTile?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
                    textAlign = TextAlign.Center
                )
            }

            // video config by lazy
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center, // Ensures equal spacing
                verticalAlignment = Alignment.CenterVertically
            ) {
                page.videoConfig?.languages?.let { languages ->
                    if (languages.isNotEmpty()) {
                        item {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Language Icon
                                Box(
                                    modifier = Modifier
                                        .border(
                                            width = size1,
                                            color = Color.White,
                                            shape = RoundedCornerShape(size4)
                                        )
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_logo), // Replace with actual language icon
                                        contentDescription = "Language Icon",
                                        modifier = Modifier
                                            .size(24.dp)
                                            .padding(4.dp),
                                        contentScale = ContentScale.Inside
                                    )
                                }

                                Spacer(modifier = Modifier.width(4.dp))

                                // Language Text
                                val displayText = if (languages.size > 1) {
                                    "${languages.first()} +${languages.size - 1}" // e.g., "English +4"
                                } else {
                                    languages.first()
                                }

                                Text(
                                    text = displayText,
                                    style = MaterialTheme.typography.labelMedium.copy(color = Color.White)
                                )
                            }
                        }
                    }
                }
                page.videoConfig?.labels?.let { labels ->
                    items(labels) { label ->
                        Box(
                            modifier = Modifier
                                .padding(size3)
                                .border(
                                    width = size1,
                                    color = Color.White,
                                    shape = RoundedCornerShape(size4)
                                )
                        ) {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                shape = RoundedCornerShape(size8),
                onClick = { /* Handle Buy Now */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD700)) // Yellow Button
            ) {
                page.ctaText?.let { Text(it, color = Color.Black) }
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(
        page = OnboardingPage(
            logos = listOf(
                "https://cordcutting.com/wp-content/uploads/2015/08/nfl-gamepass.png",
            ),
            title = "Watch all live FIFA Club World Cup only on DAZN",
            subTile = "The world's biggest clubs battle for football’s ultimate crown.",
            dateAndTime = "10 FEB • 01:30",
            backgroundImage = "https://images.ctfassets.net/vhp9jnid12wf/wLOhaDWVnUcuCvElWn5CS/532ca3e478b75143f58baa7c1e06c6be/UK_Hero_Banner_Mobile_OB_750_X_1624_2x.jpg",
            ctaText = "Learn more",
            ctaColor = Color.White,
            ctaTextColor = Color.Black,
            videoConfig = VideoConfig(
                listOf(
                    "English", "Spain", "Japanese", "Hindi", "Korean", "Chinese"
                ), listOf(
                    "HDR", "4K", "5.1"
                )
            ),
        )
    )
}