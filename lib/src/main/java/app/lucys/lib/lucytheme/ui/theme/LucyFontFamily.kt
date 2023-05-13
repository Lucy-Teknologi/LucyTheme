package app.lucys.lib.lucytheme.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import app.lucys.lib.lucytheme.R

/**
 * Font families used in the design system
 */
internal val LucyFontFamily = FontFamily(
    Font(R.font.nunitosans_regular, LucyFontWeight.Regular),
    Font(R.font.nunitosans_semibold, LucyFontWeight.SemiBold),
    Font(R.font.nunitosans_bold, LucyFontWeight.Bold),
    Font(R.font.nunitosans_extrabold, LucyFontWeight.ExtraBold),
)

/**
 * Font family for brand in the design system
 */
internal val LucyBrandFontFamily = FontFamily(Font(R.font.pacifico_regular))