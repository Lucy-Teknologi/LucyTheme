package app.lucys.lib.lucytheme.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Primary Colors
internal val PrimaryMain = Color(0xFFFF2352)
internal val PrimarySurface = Color(0xFFFFD3DC)
internal val PrimaryBorder = Color(0xFFFFB6C5)
internal val PrimaryHover = Color(0xFFD51D44)
internal val PrimaryPressed = Color(0xFF801129)
internal val PrimaryFocus = Color(0xFFF3C4CE)

// Neutral Colors
internal val Neutral10 = Color(0xFFFFFFFF)
internal val Neutral20 = Color(0xFFF5F5F5)
internal val Neutral30 = Color(0xFFEDEDED)
internal val Neutral40 = Color(0xFFE0E0E0)
internal val Neutral50 = Color(0xFFC2C2C2)
internal val Neutral60 = Color(0xFF9E9E9E)
internal val Neutral70 = Color(0xFF757575)
internal val Neutral80 = Color(0xFF616161)
internal val Neutral90 = Color(0xFF404040)
internal val Neutral100 = Color(0xFF0A0A0A)

// Success Colors
internal val SuccessMain = Color(0xFF65C466)
internal val SuccessSurface = Color(0xFFE0F3F0)
internal val SuccessBorder = Color(0xFFCCEBCC)
internal val SuccessHover = Color(0xFF54A355)
internal val SuccessPressed = Color(0xFF326233)

// Error Colors
internal val ErrorMain = Color(0xFFED4330)
internal val ErrorSurface = Color(0xFFFBD9D6)
internal val ErrorBorder = Color(0xFFF9C0BA)
internal val ErrorHover = Color(0xFFC53828)
internal val ErrorPressed = Color(0xFF762118)

// Info Colors
internal val InfoMain = Color(0xFF3267E3)
internal val InfoSurface = Color(0xFFF0F3FF)
internal val InfoBorder = Color(0xFFB1C5F6)
internal val InfoHover = Color(0xFF114CD6)
internal val InfoPressed = Color(0xFF11317D)

// Danger Colors
internal val DangerMain = Color(0xFFED8D30)
internal val DangerSurface = Color(0xFFFBE8D6)
internal val DangerBorder = Color(0xFFF9D8BA)
internal val DangerHover = Color(0xFFC57428)
internal val DangerPressed = Color(0xFF764518)

val LucyLightColors = LucyColors(
    primaryMain = PrimaryMain,
    primarySurface = PrimarySurface,
    primaryBorder = PrimaryBorder,
    primaryHover = PrimaryHover,
    primaryPressed = PrimaryPressed,
    primaryFocus = PrimaryFocus,

    neutral10 = Neutral10,
    neutral20 = Neutral20,
    neutral30 = Neutral30,
    neutral40 = Neutral40,
    neutral50 = Neutral50,
    neutral60 = Neutral60,
    neutral70 = Neutral70,
    neutral80 = Neutral80,
    neutral90 = Neutral90,
    neutral100 = Neutral100,

    successMain = SuccessMain,
    successSurface = SuccessSurface,
    successBorder = SuccessBorder,
    successHover = SuccessHover,
    successPressed = SuccessPressed,

    errorMain = ErrorMain,
    errorSurface = ErrorSurface,
    errorBorder = ErrorBorder,
    errorHover = ErrorHover,
    errorPressed = ErrorPressed,

    infoMain = InfoMain,
    infoSurface = InfoSurface,
    infoBorder = InfoBorder,
    infoHover = InfoHover,
    infoPressed = InfoPressed,

    dangerMain = DangerMain,
    dangerSurface = DangerSurface,
    dangerBorder = DangerBorder,
    dangerHover = DangerHover,
    dangerPressed = DangerPressed,
)

@Immutable
data class LucyColors(
    val primaryMain: Color,
    val primarySurface: Color,
    val primaryBorder: Color,
    val primaryHover: Color,
    val primaryPressed: Color,
    val primaryFocus: Color,

    val neutral10: Color,
    val neutral20: Color,
    val neutral30: Color,
    val neutral40: Color,
    val neutral50: Color,
    val neutral60: Color,
    val neutral70: Color,
    val neutral80: Color,
    val neutral90: Color,
    val neutral100: Color,

    val successMain: Color,
    val successSurface: Color,
    val successBorder: Color,
    val successHover: Color,
    val successPressed: Color,

    val errorMain: Color,
    val errorSurface: Color,
    val errorBorder: Color,
    val errorHover: Color,
    val errorPressed: Color,

    val infoMain: Color,
    val infoSurface: Color,
    val infoBorder: Color,
    val infoHover: Color,
    val infoPressed: Color,

    val dangerMain: Color,
    val dangerSurface: Color,
    val dangerBorder: Color,
    val dangerHover: Color,
    val dangerPressed: Color,
)

internal val LocalLucyColors = staticCompositionLocalOf {
    LucyColors(
        primaryMain = Color.Unspecified,
        primarySurface = Color.Unspecified,
        primaryBorder = Color.Unspecified,
        primaryHover = Color.Unspecified,
        primaryPressed = Color.Unspecified,
        primaryFocus = Color.Unspecified,

        neutral10 = Color.Unspecified,
        neutral20 = Color.Unspecified,
        neutral30 = Color.Unspecified,
        neutral40 = Color.Unspecified,
        neutral50 = Color.Unspecified,
        neutral60 = Color.Unspecified,
        neutral70 = Color.Unspecified,
        neutral80 = Color.Unspecified,
        neutral90 = Color.Unspecified,
        neutral100 = Color.Unspecified,

        successMain = Color.Unspecified,
        successSurface = Color.Unspecified,
        successBorder = Color.Unspecified,
        successHover = Color.Unspecified,
        successPressed = Color.Unspecified,

        errorMain = Color.Unspecified,
        errorSurface = Color.Unspecified,
        errorBorder = Color.Unspecified,
        errorHover = Color.Unspecified,
        errorPressed = Color.Unspecified,

        infoMain = Color.Unspecified,
        infoSurface = Color.Unspecified,
        infoBorder = Color.Unspecified,
        infoHover = Color.Unspecified,
        infoPressed = Color.Unspecified,

        dangerMain = Color.Unspecified,
        dangerSurface = Color.Unspecified,
        dangerBorder = Color.Unspecified,
        dangerHover = Color.Unspecified,
        dangerPressed = Color.Unspecified,
    )
}
