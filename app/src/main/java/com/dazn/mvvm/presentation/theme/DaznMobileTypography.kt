package com.dazn.common.compose.mobile.theme

import DaznMobileFonts.OscineSemiBold
import DaznMobileFonts.Trim
import DaznMobileFonts.TrimBold
import DaznMobileFonts.TrimCondensedDisplayBold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.font.FontWeight.Companion.W800
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import com.dazn.mvvm.presentation.theme.Black
import com.dazn.mvvm.presentation.theme.Chalk
import com.dazn.mvvm.presentation.theme.Ebony
import com.dazn.mvvm.presentation.theme.Iron
import com.dazn.mvvm.presentation.theme.Oscine
import com.dazn.mvvm.presentation.theme.Primer
import com.dazn.mvvm.presentation.theme.Smoky
import com.dazn.mvvm.presentation.theme.Tarmac100
import com.dazn.mvvm.presentation.theme.White
import com.dazn.mvvm.presentation.theme.fontSize0_8
import com.dazn.mvvm.presentation.theme.fontSize12
import com.dazn.mvvm.presentation.theme.fontSize14
import com.dazn.mvvm.presentation.theme.fontSize16
import com.dazn.mvvm.presentation.theme.fontSize18
import com.dazn.mvvm.presentation.theme.fontSize20
import com.dazn.mvvm.presentation.theme.fontSize24
import com.dazn.mvvm.presentation.theme.fontSize28
import com.dazn.mvvm.presentation.theme.fontSize32
import com.dazn.mvvm.presentation.theme.fontSize36
import com.dazn.mvvm.presentation.theme.fontSize38
import com.dazn.mvvm.presentation.theme.fontSize40
import com.dazn.mvvm.presentation.theme.fontSize44
import com.dazn.mvvm.presentation.theme.fontSize48
import com.dazn.mvvm.presentation.theme.fontSize60
import com.dazn.mvvm.presentation.theme.fontSize72

class DaznMobileTypography {
    val daznButton = TextStyle(
        fontFamily = TrimBold,
        color = Tarmac100,
        fontSize = fontSize16,
        letterSpacing = 0.em,
        lineHeight = fontSize24,
    )

    val daznButtonTransparent = TextStyle(
        fontFamily = TrimBold,
        color = Chalk,
        fontSize = fontSize16,
        letterSpacing = 0.em,
    )

    val header2Bold = TextStyle(
        fontFamily = TrimBold,
        color = Chalk,
        fontSize = fontSize32,
        lineHeight = fontSize36,
        fontWeight = W700,
    )

    val header3Bold = TextStyle(
        fontFamily = TrimBold,
        color = White,
        fontSize = fontSize24,
        lineHeight = fontSize28,
    )

    val subHeaderRegular = TextStyle(
        color = Chalk,
        fontFamily = Oscine,
        fontSize = fontSize12,
    )

    val chalkTrim14 = TextStyle(
        fontFamily = Trim,
        fontSize = fontSize14,
        color = Chalk,
    )

    val chalkTrim14Badge = TextStyle(
        fontFamily = Trim,
        fontWeight = Bold,
        fontSize = fontSize12,
        textAlign = TextAlign.Center,
        color = Chalk,
    )

    val ebonyTrim14Badge = TextStyle(
        fontFamily = Trim,
        fontWeight = Bold,
        fontSize = fontSize12,
        textAlign = TextAlign.Center,
        color = Black,
    )

    val ironTrim12 = TextStyle(
        fontFamily = Trim,
        fontSize = fontSize12,
        color = Iron,
    )

    val ironTrim14 = TextStyle(
        fontFamily = Trim,
        fontSize = fontSize14,
        color = Iron,
    )

    val subHeaderMedium = TextStyle(
        color = Chalk,
        fontFamily = Trim,
        fontSize = fontSize16,
        fontWeight = Medium,
    )

    val body3Regular = TextStyle(
        color = Primer,
        fontFamily = Oscine,
        fontSize = fontSize12,
        lineHeight = fontSize20,
        fontWeight = W400,
        textAlign = TextAlign.Center
    )

    val body3Bold = TextStyle(
        color = Chalk,
        fontFamily = Oscine,
        fontSize = fontSize12,
        lineHeight = fontSize20,
        fontWeight = Bold,
    )

    val body4Regular = TextStyle(
        color = Iron,
        fontFamily = Oscine,
        fontSize = fontSize16,
    )

    val header4Bold = TextStyle(
        fontFamily = TrimBold,
        color = Chalk,
        fontSize = fontSize24,
        fontWeight = Bold,
    )

    val header4Regular = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize24,
        lineHeight = fontSize32,
        fontWeight = W400,
    )

    val body4Dark = TextStyle(
        fontFamily = Oscine,
        fontWeight = Normal,
        fontSize = fontSize16,
        color = Smoky,
    )

    val header3Strong = TextStyle(
        fontFamily = TrimCondensedDisplayBold,
        color = Chalk,
        fontSize = fontSize72,
        letterSpacing = 0.02.em,
        lineHeight = fontSize60,
        fontWeight = Bold,
    )

    val header4Strong = TextStyle(
        fontFamily = TrimCondensedDisplayBold,
        color = Chalk,
        fontSize = fontSize48,
        letterSpacing = 0.02.em,
        lineHeight = fontSize40,
        fontWeight = Bold,
    )

    val header6Bold = TextStyle(
        fontSize = fontSize18,
        lineHeight = fontSize24,
        fontFamily = TrimBold,
        fontWeight = FontWeight(700),
        color = Chalk,
        textAlign = TextAlign.Center,
    )

    val header7Regular = TextStyle(
        fontFamily = Trim,
        color = Chalk,
        fontSize = fontSize16,
        fontWeight = W400
    )

    val header7Bold = TextStyle(
        fontFamily = TrimBold,
        color = Color.White,
        fontSize = fontSize16,
        fontWeight = Bold,
    )

    val body2Regular = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize14,
        fontWeight = Normal,
        lineHeight = fontSize20,
    )

    val body2Bold = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize14,
        fontWeight = Bold,
        lineHeight = fontSize20,
    )

    val trim16Bold = TextStyle(
        fontFamily = TrimBold,
        fontWeight = Bold,
        fontSize = fontSize16,
        lineHeight = fontSize24,
        color = White,
    )

    val trim32Bold = TextStyle(
        fontFamily = TrimBold,
        fontWeight = Bold,
        fontSize = fontSize32,
        lineHeight = fontSize24,
        color = White,
    )

    val body1Regular = TextStyle(
        fontFamily = Oscine,
        fontWeight = Normal,
        fontSize = fontSize16,
        lineHeight = fontSize24,
        color = Iron,
    )

    val header5Bold = TextStyle(
        fontFamily = TrimBold,
        fontWeight = Bold,
        fontSize = fontSize20,
        lineHeight = fontSize24,
        color = Ebony,
    )

    val railHeader = TextStyle(
        color = Chalk,
        fontFamily = TrimBold,
        fontWeight = W700,
        fontSize = fontSize14,
        fontStyle = FontStyle.Normal
    )

    val railTitle = TextStyle(
        color = Chalk,
        fontFamily = TrimBold,
        fontWeight = W700,
        fontSize = fontSize12,
        fontStyle = FontStyle.Normal
    )

    val labelText = TextStyle(
        color = Chalk,
        fontFamily = Oscine,
        fontWeight = W800,
        fontSize = fontSize14,
        fontStyle = FontStyle.Normal,
        platformStyle = PlatformTextStyle(
            includeFontPadding = true
        )
    )

    val oscine28ExtraBold = TextStyle(
        fontFamily = Oscine,
        fontSize = fontSize28,
        fontWeight = ExtraBold,
        color = Tarmac100
    )

    val oscine44Bold = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize44,
        fontWeight = W700,
        lineHeight = fontSize44,
    )

    val oscine40Bold = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize40,
        fontWeight = W700,
        letterSpacing = -fontSize0_8,
        lineHeight = fontSize44,
    )

    val oscine36Bold = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize36,
        fontWeight = W700,
        letterSpacing = -fontSize0_8,
        lineHeight = fontSize38,
    )

    val oscine20Bold = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize20,
        fontWeight = W700,
        letterSpacing = 0.em,
        lineHeight = fontSize28,
    )

    val oscine20SemiBold = TextStyle(
        fontFamily = OscineSemiBold,
        color = Chalk,
        fontSize = fontSize20,
        fontWeight = W400,
        letterSpacing = -fontSize0_8,
        lineHeight = fontSize28,
    )

    val oscine24Bold = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize24,
        lineHeight = fontSize28,
        fontWeight = W700,
    )

    val oscine32Bold = TextStyle(
        fontFamily = Oscine,
        color = Chalk,
        fontSize = fontSize32,
        lineHeight = fontSize36,
        fontWeight = W700,
    )

    val oscine18Regular = TextStyle(
        fontFamily = Oscine,
        color = Primer,
        fontSize = fontSize18,
        lineHeight = fontSize24,
        fontWeight = W400,
    )

    val oscine14Regular = TextStyle(
        fontFamily = Oscine,
        color = Primer,
        fontSize = fontSize14,
        lineHeight = fontSize20,
        fontWeight = W400,
    )

    val includeFontPadding = TextStyle(
        platformStyle = PlatformTextStyle(includeFontPadding = true),
    )
}

val LocalTypography = compositionLocalOf { DaznMobileTypography() }

val daznMobileTypography: DaznMobileTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current