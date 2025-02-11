package com.dazn.mvvm.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dazn.mvvm.presentation.theme.ScreenDensityMultiplier.PX_TO_DP_FACTOR_1080
import com.dazn.mvvm.presentation.theme.ScreenDensityMultiplier.PX_TO_DP_FACTOR_720

class Spacing(val screenDensityMultiplier: Double) {
    val superTiny = (4 * screenDensityMultiplier).dp
    val tiny = (11 * screenDensityMultiplier).dp
    val verySmall = (15 * screenDensityMultiplier).dp
    val small = (32 * screenDensityMultiplier).dp
    val medium = 32.dp
    val big = (98 * screenDensityMultiplier).dp
    val veryBig = (112 * screenDensityMultiplier).dp
    val large = (143 * screenDensityMultiplier).dp

    val menuStartPadding = (48 * screenDensityMultiplier).dp
    val menuItemSeparatorHeight = (48 * screenDensityMultiplier).dp
    val menuItemPadding = (12 * screenDensityMultiplier).dp
    val menuItemTextMargin = (44 * screenDensityMultiplier).dp
    val menuItemTextOffset = (3 * screenDensityMultiplier).dp
    val subMenuItemTextDefaultStartPadding = (16 * screenDensityMultiplier).dp
    val subMenuItemTextFocusedStartPadding = (12 * screenDensityMultiplier).dp

    val showTileLogoPadding = (54 * screenDensityMultiplier).dp
    val unfocusedTileTextPadding = (14 * screenDensityMultiplier).dp
    val ageWatermarkPadding = (8 * screenDensityMultiplier).dp
    val ageWatermarkExpandedPadding = (78 * screenDensityMultiplier).dp
    val purchasedLabelPadding = (6 * screenDensityMultiplier).dp
    val addonLabelPadding = (8 * screenDensityMultiplier).dp

    val tabsSpacing = (48 * screenDensityMultiplier).dp
    val liveTimeSpacing = (16 * screenDensityMultiplier).dp
    val controlsBottomPadding = (76 * screenDensityMultiplier).dp
    val controlsBottomButtonMargin = (16 * screenDensityMultiplier).dp
    val controlsSectionsSpacing = (41 * screenDensityMultiplier).dp
    val playerSubtitleSpacing = (16 * screenDensityMultiplier).dp
    val playerSubtitleTopSpace = (8 * screenDensityMultiplier).dp
    val playerDescriptionTopSpace = (16 * screenDensityMultiplier).dp
    val seekingTimeStampStartPadding = (13 * screenDensityMultiplier).dp

    val comingUpDescriptionTopSpace = (32 * screenDensityMultiplier).dp
    val comingUpButtonTopSpace = (48 * screenDensityMultiplier).dp
    val comingUpButtonTextPadding = (15 * screenDensityMultiplier).dp

    val guidanceStartPadding = (202 * screenDensityMultiplier).dp
    val guidanceEndPadding = (138 * screenDensityMultiplier).dp
    val guidanceDescriptionTopPadding = (49 * screenDensityMultiplier).dp
    val guidanceStepsTopPadding = (57 * screenDensityMultiplier).dp
    val guidanceActionHorizontalPadding = (114 * screenDensityMultiplier).dp

    val sportScreenTitleTopPaddingFirstItemFocused = (122 * screenDensityMultiplier).dp
    val sportScreenTitleTopPadding = (51 * screenDensityMultiplier).dp

    val settingsTitleTopPadding = (51 * screenDensityMultiplier).dp
    val settingsItemTextStartPadding = (24 * screenDensityMultiplier).dp
    val settingsItemIconEndPadding = (24 * screenDensityMultiplier).dp
    val settingsBodySidePadding = (360 * screenDensityMultiplier).dp
    val settingsBodyStartPadding = (360 * screenDensityMultiplier).dp
    val settingsBodyEndPadding = (296 * screenDensityMultiplier).dp
    val settingsBodyTopPadding = (299 * screenDensityMultiplier).dp
    val settingsBodyEndToScrollPadding = (64 * screenDensityMultiplier).dp
    val settingsBodyBottomPadding = (132 * screenDensityMultiplier).dp
    val settingsScrollbarWidth = (4 * screenDensityMultiplier).dp
    val settingsFadingEdgeHeight = (76 * screenDensityMultiplier).dp

    val pinEntryTitleTopPadding = (313 * screenDensityMultiplier).dp
    val pinEntryDescriptionTopPadding = (35 * screenDensityMultiplier).dp
    val pinInputFieldTopPadding = (377 * screenDensityMultiplier).dp

    val signOutTitleTopPadding = (348 * screenDensityMultiplier).dp
    val signOutDescriptionBottomPadding = (503 * screenDensityMultiplier).dp

    val signInTextFieldHorizontalPadding = (16 * screenDensityMultiplier).dp
    val signInTextFieldLabelPadding = (8 * screenDensityMultiplier).dp
    val signInVerticalSpacing = (16 * screenDensityMultiplier).dp
    val signInVerticalButtonsSpacing = (32 * screenDensityMultiplier).dp
    val signInInputSectionVerticalPadding = (60 * screenDensityMultiplier).dp
    val signInInputSectionStartPadding = (135 * screenDensityMultiplier).dp

    val dualSignInVerticalSpacing = (64 * screenDensityMultiplier).dp
    val dualSignInInputSectionTopPadding = (200 * screenDensityMultiplier).dp
    val dualSignInInputSectionStartPadding = (196 * screenDensityMultiplier).dp
    val dualSignInForgotYourPasswordTextTopSpacing = (128 * screenDensityMultiplier).dp
    val dualSignInForgotYourPasswordTextBottomSpacing = (32 * screenDensityMultiplier).dp

    val signInQrSectionTopPadding = (118 * screenDensityMultiplier).dp

    val docomoSignInStartPadding = (196 * screenDensityMultiplier).dp
    val docomoSignInTopPadding = (236 * screenDensityMultiplier).dp
    val docomoSignInSmallVerticalSpacing = (16 * screenDensityMultiplier).dp
    val docomoSignInBigVerticalSpacing = (40 * screenDensityMultiplier).dp
    val docomoSignInEnterPinTextWidth = (1257 * screenDensityMultiplier).dp

    val signUpHeaderBottomPadding = (64 * screenDensityMultiplier).dp
    val signUpHeaderTopPadding = (80 * screenDensityMultiplier).dp
    val signUpContinueButtonTopPadding = (128 * screenDensityMultiplier).dp
    val signUpConsentsNextPreviousButtonTopPadding = (80 * screenDensityMultiplier).dp
    val signUpConsentsNextPreviousButtonSpace = (50 * screenDensityMultiplier).dp
    val signUpConsentsSidePadding = (440 * screenDensityMultiplier).dp
    val signUpConsentsItemSpacer = (15 * screenDensityMultiplier).dp
    val signUpSummarySidePadding = (360 * screenDensityMultiplier).dp
    val signUpSummaryDescriptionTopPadding = (32 * screenDensityMultiplier).dp
    val signUpSummaryDescriptionBottomPadding = (40 * screenDensityMultiplier).dp

    val daznThinButtonVerticalPadding = (16 * screenDensityMultiplier).dp

    val errorTitleBottomPadding = (49 * screenDensityMultiplier).dp
    val errorSubtitleBottomPadding = (23 * screenDensityMultiplier).dp

    val appReportQrCodeSize = (357 * screenDensityMultiplier).dp
    val appReportItemsVerticalPadding = (56 * screenDensityMultiplier).dp
    val appReportContentTopPadding = (250 * screenDensityMultiplier).dp

    val timeoutHeaderBottomPadding = (49 * screenDensityMultiplier).dp
    val timeoutHeaderTopPadding = (55 * screenDensityMultiplier).dp
    val timeoutPrimaryButtonStartPadding = (71 * screenDensityMultiplier).dp
    val timeoutPrimaryButtonEndPadding = (122 * screenDensityMultiplier).dp

    val adsConsentTitleTopPadding = (51 * screenDensityMultiplier).dp
    val adsConsentContentTopPadding = (123 * screenDensityMultiplier).dp
    val adsConsentContentHorizontalPadding = (285 * screenDensityMultiplier).dp
    val adsConsentButtonsTopPadding = (249 * screenDensityMultiplier).dp
    val adsConsentButtonsWithCheckboxTopPadding = (32 * screenDensityMultiplier).dp
    val adsConsentMoreOptionsBottomTextTopPadding = (42 * screenDensityMultiplier).dp
    val adsConsentBottomTextWithButtonsTopPadding = (42 * screenDensityMultiplier).dp
    val adsConsentBottomTextTopPadding = (42 * screenDensityMultiplier).dp
    val adsConsentMoreOptionsItemBottomPadding = (64 * screenDensityMultiplier).dp
    val adsInQrPadding = (400 * screenDensityMultiplier).dp
    val adsConsentTitleTopPaddingNew = (32 * screenDensityMultiplier).dp
    val pinProtectionVerticalPadding = (12 * screenDensityMultiplier).dp

    val userMessagesContentStartPadding = (202 * screenDensityMultiplier).dp
    val userMessagesContentVerticalPadding = (134 * screenDensityMultiplier).dp
    val userMessagesContentEndPadding = (142 * screenDensityMultiplier).dp
    val userMessagesActionSectionHorizontalStartPadding = (71 * screenDensityMultiplier).dp
    val userMessagesActionSectionHorizontalEndPadding = (122 * screenDensityMultiplier).dp
    val userMessagesScrollableContentTopPadding = (49 * screenDensityMultiplier).dp
    val userMessagesButtonWidth = (507 * screenDensityMultiplier).dp

    val lockIconPadding = (8 * screenDensityMultiplier).dp
    val liveBadgeHorizontalPadding = (13 * screenDensityMultiplier).dp
    val backToLiveVerticalPadding = (4 * screenDensityMultiplier).dp
    val backToLiveButtonContentPadding = (10 * screenDensityMultiplier).dp
    val backToLiveButtonTopPadding = (26 * screenDensityMultiplier).dp
    val topTileIconsPadding = (10 * screenDensityMultiplier).dp
    val topTileIconsSpaceByPadding = (8 * screenDensityMultiplier).dp

    val resetPasswordContentStartPadding = (150 * screenDensityMultiplier).dp
    val resetPasswordContentTopPadding = (310 * screenDensityMultiplier).dp
    val resetPasswordLogoPadding = (20 * screenDensityMultiplier).dp
    val resetPasswordTitlePadding = (40 * screenDensityMultiplier).dp
    val resetPasswordEmailLabelPadding = (12 * screenDensityMultiplier).dp
    val resetPasswordEmailPadding = (96 * screenDensityMultiplier).dp
    val resetPasswordCtaButtonPadding = (35 * screenDensityMultiplier).dp
    val topTileIconsBottomPadding = (20 * screenDensityMultiplier).dp
}

val sh720Spacing = Spacing(PX_TO_DP_FACTOR_720)
val sh1080Spacing = Spacing(PX_TO_DP_FACTOR_1080)

val LocalSpacing = compositionLocalOf { sh1080Spacing }

val spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current

@Stable
@Composable
@ReadOnlyComposable
fun Dp.withScreenDensity(): Dp =
    value.withScreenDensity(spacing.screenDensityMultiplier).dp

@Stable
@Composable
@ReadOnlyComposable
fun TextUnit.withScreenDensity(): TextUnit =
    value.withScreenDensity(spacing.screenDensityMultiplier).sp

fun <T : Number> T.withScreenDensity(screenDensityMultiplier: Double): Float =
    (this.toFloat() * screenDensityMultiplier).toFloat()


object ScreenDensityMultiplier {
    const val PX_TO_DP_FACTOR_1080 = 0.5
    const val PX_TO_DP_FACTOR_720 = 0.5
}