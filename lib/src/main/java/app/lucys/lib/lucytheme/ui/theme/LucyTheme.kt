package app.lucys.lib.lucytheme.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun LucyTheme(
    isDarkTheme: Boolean = false,
    lightColors: LucyColors? = null,
    darkColors: LucyColors? = null,
    typography: LucyTypography? = null,
    spacing: LucyDimension? = null,
    content: @Composable () -> Unit,
) {
    val colors = when (isDarkTheme) {
        true -> darkColors ?: LucyLightColors
        false -> lightColors ?: LucyLightColors
    }
    val mTypography = typography ?: LucyMobileTypography
    val dimension = spacing ?: LucyMobileDimension

    CompositionLocalProvider(
        LocalLucyColors provides colors,
        LocalLucyTypography provides mTypography,
        LocalLucyDimension provides dimension,
    ) {
        content()
    }
}

object LucyTheme {
    val colors: LucyColors
        @Composable
        get() = LocalLucyColors.current
    val typography: LucyTypography
        @Composable
        get() = LocalLucyTypography.current
    val spacing: LucyDimension
        @Composable
        get() = LocalLucyDimension.current
}