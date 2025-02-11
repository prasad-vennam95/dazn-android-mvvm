package com.dazn.mvvm.data.model

import androidx.compose.ui.graphics.Color

data class OnboardingPage(
    val logos: List<String>? = null,
    val title: String? = null,
    val subTile: String? = null,
    val dateAndTime: String? = null,
    val backgroundImage: String? = null,
    val ctaText: String? = null,
    val ctaColor: Color? = null,
    val ctaTextColor: Color? = null,
    val videoConfig: VideoConfig? = null
)

data class VideoConfig(
    val languages: List<String>? = null,
    val labels: List<String>? = null
)


val onboardPages = listOf(
    OnboardingPage(
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
                "English", "Spain","Japanese","Hindi","Korean","Chinese"
            ),
            listOf(
                "HDR", "4K", "5.1"
            )
        ),
    ),

    OnboardingPage(
        logos = listOf(
            "https://image.discovery.indazn.com/jp/v3/jp/none/700f3d43-5b53-4e4f-a830-ad7c08117100/fill/none/top/none/49/200/200/webp/image",
            "https://image.discovery.indazn.com/jp/v3/jp/none/8d0bd143-4dad-4b98-b874-5eee6338b5d2/fill/none/top/none/49/200/200/webp/image"
        ),
        title = "Experience the thrill of UFC live on DAZN",
        subTile = "Watch every fight, every round, live and exclusive.",
        dateAndTime = "15 MAR • 20:00",
        backgroundImage = "https://images.ctfassets.net/vhp9jnid12wf/1waPHZh4iNVuhDyBc1Ywab/94a75ce995fdeb8537264273747f5054/RAt_4uFb.jpeg?fm=webp",
        ctaText = "Subscribe now",
        ctaColor = Color.Red,
        ctaTextColor = Color.White,
        videoConfig = VideoConfig(
            listOf(
                "English", "Spain"
            ),
            null
        ),
    ),

    OnboardingPage(
        logos = listOf(
            "https://image.discovery.indazn.com/jp/v3/jp/none/9105f04d-f9f3-404d-9336-e2d756b7837d/fill/none/top/none/49/200/200/webp/image",
            "https://image.discovery.indazn.com/jp/v3/jp/none/4366b040-3f3f-4997-b117-d681476e5ee7/fill/none/top/none/49/200/200/webp/image",
            "https://image.discovery.indazn.com/jp/v3/jp/none/a8628a34-d093-469c-9725-59ebbd4e6b26/fill/none/top/none/49/200/200/webp/image"
        ),
        title = "NBA Playoffs live on DAZN - Don't miss a moment",
        subTile = "Catch all the action from the biggest teams in basketball.",
        dateAndTime = "22 APR • 18:00",
        backgroundImage = "https://images.ctfassets.net/vhp9jnid12wf/6vdHUCqzniLhIxSMWbbNch/5040ffadb935f347ead6ce7fed0205fd/Womens_Football_Locked_640x1138.jpg?fm=webp",
        ctaText = "Watch now",
        ctaColor = Color.Yellow,
        ctaTextColor = Color.Black,
        videoConfig = null
    ),

    OnboardingPage(
        logos = null,
        title = "The biggest boxing fights live exclusively on DAZN",
        subTile = "World champions, thrilling knockouts, only on DAZN.",
        dateAndTime = "5 MAY • 22:00",
        backgroundImage = "https://images.ctfassets.net/vhp9jnid12wf/5qKAyfFUhJqJ1S4AzoI2AL/9da640633c5a0c613cfda4e58d1c1814/New_Project__2_.png?fm=webp",
        ctaText = "Buy now",
        ctaColor = Color.Blue,
        ctaTextColor = Color.White,
        videoConfig = VideoConfig(
            null,
            listOf(
                "HDR", "4K", "5.1"
            )
        ),
    )
)


