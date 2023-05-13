package app.lucys.lib.lucytheme.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontWeight

@Immutable
class LucyFontWeight {
    companion object {
        val Regular: FontWeight = FontWeight(400)
        val SemiBold: FontWeight = FontWeight(600)
        val Bold: FontWeight = FontWeight(700)
        val ExtraBold: FontWeight = FontWeight(800)
    }
}