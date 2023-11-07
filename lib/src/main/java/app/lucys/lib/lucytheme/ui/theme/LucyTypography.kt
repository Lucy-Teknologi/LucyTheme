package app.lucys.lib.lucytheme.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Immutable
data class LucyTypography(
    // Titles
    val largeTitle: TextStyle,
    val mediumTitle: TextStyle,
    val smallTitle: TextStyle,
    val xSmallTitle: TextStyle,

    // Headlines
    val largeHeadline: TextStyle,
    val mediumHeadline: TextStyle,
    val smallHeadline: TextStyle,
    val xSmallHeadline: TextStyle,

    // Body
    val largeBody: TextStyle,
    val mediumBody: TextStyle,
    val smallBody: TextStyle,
    val xSmallBody: TextStyle,

    // Buttons
    val largeButton: TextStyle,
    val smallButton: TextStyle,

    // Captions
    val mediumCaption: TextStyle,
    val smallCaption: TextStyle,
    val boldCaption: TextStyle,

    // Misc
    val label: TextStyle,
    val brand: TextStyle,
)

internal val LucyTabletTypography = LucyTypography(
    brand = TextStyle(
        fontFamily = LucyBrandFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 36.sp,
    ),
    largeTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 28.sp,
        lineHeight = 52.sp,
    ),
    mediumTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 24.sp,
        lineHeight = 44.sp,
    ),
    smallTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 20.sp,
        lineHeight = 38.sp,
    ),
    xSmallTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 16.sp,
        lineHeight = 32.sp,
    ),
    largeHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 44.sp,
    ),
    mediumHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 38.sp,
    ),
    smallHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 32.sp,
    ),
    xSmallHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    largeBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 20.sp,
        lineHeight = 38.sp,
    ),
    mediumBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 16.sp,
        lineHeight = 32.sp,
    ),
    smallBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    xSmallBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 12.sp,
        lineHeight = 22.sp,
    ),
    largeButton = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    smallButton = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
    mediumCaption = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.SemiBold,
        fontSize = 12.sp,
    ),
    smallCaption = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 10.sp,
    ),
    boldCaption = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 10.sp,
        letterSpacing = 0.5.sp,
    ),
    label = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 10.sp,
    ),
)

internal val LucyMobileTypography = LucyTypography(
    brand = TextStyle(
        fontFamily = LucyBrandFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 36.sp,
    ),
    largeTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 24.sp,
    ),
    mediumTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 20.sp,
    ),
    smallTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 16.sp,
    ),
    xSmallTitle = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.ExtraBold,
        fontSize = 14.sp,
    ),
    largeHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 20.sp,
    ),
    mediumHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 16.sp,
    ),
    smallHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 14.sp,
    ),
    xSmallHeadline = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 12.sp,
    ),
    largeBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 16.sp,
    ),
    mediumBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 14.sp,
    ),
    smallBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 12.sp,
    ),
    xSmallBody = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 12.sp,
    ),
    largeButton = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.SemiBold,
        fontSize = 14.sp,
    ),
    smallButton = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.SemiBold,
        fontSize = 12.sp,
    ),
    mediumCaption = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.SemiBold,
        fontSize = 12.sp,
    ),
    smallCaption = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Regular,
        fontSize = 10.sp,
    ),
    boldCaption = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 10.sp,
        letterSpacing = 0.5.sp,
    ),
    label = TextStyle(
        fontFamily = LucyFontFamily,
        fontWeight = LucyFontWeight.Bold,
        fontSize = 10.sp,
    ),
)

internal val LocalLucyTypography = staticCompositionLocalOf {
    LucyTypography(
        brand = TextStyle.Default,
        largeTitle = TextStyle.Default,
        mediumTitle = TextStyle.Default,
        smallTitle = TextStyle.Default,
        xSmallTitle = TextStyle.Default,
        largeHeadline = TextStyle.Default,
        mediumHeadline = TextStyle.Default,
        smallHeadline = TextStyle.Default,
        xSmallHeadline = TextStyle.Default,
        largeBody = TextStyle.Default,
        mediumBody = TextStyle.Default,
        smallBody = TextStyle.Default,
        xSmallBody = TextStyle.Default,
        largeButton = TextStyle.Default,
        smallButton = TextStyle.Default,
        mediumCaption = TextStyle.Default,
        smallCaption = TextStyle.Default,
        boldCaption = TextStyle.Default,
        label = TextStyle.Default,
    )
}