package app.lucys.lib.lucytheme.ui.widget.pager

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

/**
 * A list of defaults for lucy pager header.
 * @see LucyPagerHeader
 */
object LucyPagerHeaderDefaults {
    /**
     * The minimum width of the pager header.
     */
    val MinWidth = 100.dp

    /**
     * The maximum width of the pager header.
     */
    val MaxWidth = 160.dp

    /**
     * The minimum height of the pager header.
     */
    val MinHeight = 48.dp

    /**
     * The maximum height of the pager header.
     */
    val MaxHeight = 48.dp

    /**
     * The height of the highlight.
     */
    val HighlightHeight = 2.dp

    /**
     * The default colors for [LucyPagerHeader].
     */
    @Composable
    fun colors(): LucyPagerHeaderColors = LucyPagerHeaderColors.Default
}