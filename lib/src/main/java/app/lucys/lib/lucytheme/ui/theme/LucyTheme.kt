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
    isMobile: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colors = when (isDarkTheme) {
        true -> darkColors ?: LucyLightColors
        false -> lightColors ?: LucyLightColors
    }
    val mTypography = when {
        isMobile -> LucyMobileTypography
        else -> LucyTabletTypography
    }
    val type = typography ?: mTypography
    val dimension = spacing ?: LucyMobileDimension

    CompositionLocalProvider(
        LocalLucyColors provides colors,
        LocalLucyTypography provides type,
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