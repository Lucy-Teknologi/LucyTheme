package app.lucys.lib.lucytheme.ui.widget.pager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * A list of colors for lucy pager header.
 * @param contentColor the color of the content
 * @param highlightColor the color of the highlight
 * @param selectedContentColor the color of the content when selected
 * @param selectedHighlightColor the color of the highlight when selected
 *
 * @see LucyPagerHeaderDefaults
 * @see LucyPagerHeader
 */
@Immutable
class LucyPagerHeaderColors internal constructor(
    private val contentColor: Color,
    private val highlightColor: Color,
    private val selectedContentColor: Color,
    private val selectedHighlightColor: Color,
) {
    /**
     * Represents the content color for this button, depending on [selected].
     * @param selected whether the item is selected or not
     */
    @Composable
    internal fun contentColor(selected: Boolean): State<Color> {
        return rememberUpdatedState(
            newValue = when (selected) {
                true -> selectedContentColor
                false -> contentColor
            }
        )
    }

    /**
     * Represents the highlight color for this button, depending on [selected].
     * @param selected whether the item is selected or not
     */
    @Composable
    internal fun highlightColor(selected: Boolean): State<Color> {
        return rememberUpdatedState(
            newValue = when (selected) {
                true -> selectedHighlightColor
                false -> highlightColor
            }
        )
    }

    /**
     * Creates a copy of this [LucyPagerHeaderColors] with the given values replaced.
     * @param contentColor the color of the content
     * @param highlightColor the color of the highlight
     * @param selectedContentColor the color of the content when selected
     * @param selectedHighlightColor the color of the highlight when selected
     */
    @Composable
    fun copy(
        contentColor: Color = this.contentColor,
        highlightColor: Color = this.highlightColor,
        selectedContentColor: Color = this.selectedContentColor,
        selectedHighlightColor: Color = this.selectedHighlightColor,
    ): LucyPagerHeaderColors = LucyPagerHeaderColors(
        contentColor = contentColor,
        highlightColor = highlightColor,
        selectedContentColor = selectedContentColor,
        selectedHighlightColor = selectedHighlightColor,
    )

    companion object {
        /**
         * The default [LucyPagerHeaderColors].
         */
        val Default: LucyPagerHeaderColors
            @Composable
            get() = LucyPagerHeaderColors(
                contentColor = LucyTheme.colors.neutral90,
                highlightColor = Color.Transparent,
                selectedContentColor = LucyTheme.colors.primaryMain,
                selectedHighlightColor = LucyTheme.colors.primaryMain,
            )
    }
}