package com.dazn.mvvm.data.model

import com.dazn.mvvm.R
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class OnboardingPage(
    val background: Color,
    val title: String,
    val stepNumber: Int,
    @DrawableRes val image: Int
)

val onboardPages = listOf(
    OnboardingPage(
        background = Color.Green,
        title = "DAZN Sports With AI Match Schedule",
        stepNumber = 1,
        image = R.drawable.imag1
    ),
    OnboardingPage(
        background = Color.Green,
        title = "DAZN Sports Pay Per View ",
        stepNumber = 2,
        image = R.drawable.image2
    ),
    OnboardingPage(
        background = Color.Green,
        title = "DAZN Sports SuperBowl",
        stepNumber = 3,
        image = R.drawable.imge3
    ),
    OnboardingPage(
        background = Color.Green,
        title = "Dazn BET",
        stepNumber = 4,
        image = R.drawable.image4
    )
)