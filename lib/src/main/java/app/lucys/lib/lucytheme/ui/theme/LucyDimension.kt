package app.lucys.lib.lucytheme.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class LucyDimension(
    val xSmall: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val xLarge: Dp,
    val xxLarge: Dp,
)

internal val LucyMobileDimension: LucyDimension = LucyDimension(
    xSmall = 4.dp,
    small = 8.dp,
    medium = 12.dp,
    large = 16.dp,
    xLarge = 24.dp,
    xxLarge = 32.dp,
)

val LocalLucyDimension = staticCompositionLocalOf {
    LucyDimension(
        xSmall = Dp.Unspecified,
        small = Dp.Unspecified,
        medium = Dp.Unspecified,
        large = Dp.Unspecified,
        xLarge = Dp.Unspecified,
        xxLarge = Dp.Unspecified,
    )
}