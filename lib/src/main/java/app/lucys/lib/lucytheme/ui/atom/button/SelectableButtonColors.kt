package app.lucys.lib.lucytheme.ui.atom.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * A list of colors for selectable button.
 * @param containerColor the color of the container
 * @param contentColor the color of the content
 * @param selectedContainerColor the color of the container when selected
 * @param selectedContentColor the color of the content when selected
 * @param disabledContainerColor the color of the container when disabled
 * @param disabledContentColor the color of the content when disabled
 */
@Immutable
class SelectableButtonColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val selectedContainerColor: Color,
    private val selectedContentColor: Color,
    private val disabledContainerColor: Color,
    private val disabledContentColor: Color,
) {
    /**
     * Represents the container color for this button, depending on [enabled] and [selected].
     *
     * @param enabled whether the button is enabled
     * @param selected whether the button contains a selected item
     */
    @Composable
    internal fun containerColor(enabled: Boolean, selected: Boolean): State<Color> {
        return rememberUpdatedState(
            when {
                !enabled -> disabledContainerColor
                selected -> selectedContainerColor
                else -> containerColor
            }
        )
    }

    /**
     * Represents the content color for this button, depending on [enabled] and [selected].
     *
     * @param enabled whether the button is enabled
     * @param selected whether the button contains a selected item
     */
    @Composable
    internal fun contentColor(enabled: Boolean, selected: Boolean): State<Color> {
        return rememberUpdatedState(
            when {
                !enabled -> disabledContentColor
                selected -> selectedContentColor
                else -> contentColor
            }
        )
    }

    /**
     * Returns a copy of this [SelectableButtonColors] with the given fields replaced with the new
     * values.
     * @param containerColor the color of the container
     * @param contentColor the color of the content
     * @param selectedContainerColor the color of the container when selected
     * @param selectedContentColor the color of the content when selected
     * @param disabledContainerColor the color of the container when disabled
     * @param disabledContentColor the color of the content when disabled
     */
    fun copy(
        containerColor: Color? = null,
        contentColor: Color? = null,
        selectedContainerColor: Color? = null,
        selectedContentColor: Color? = null,
        disabledContainerColor: Color? = null,
        disabledContentColor: Color? = null,
    ): SelectableButtonColors = SelectableButtonColors(
        containerColor = containerColor ?: this.containerColor,
        contentColor = contentColor ?: this.contentColor,
        selectedContainerColor = selectedContainerColor ?: this.selectedContainerColor,
        selectedContentColor = selectedContentColor ?: this.selectedContentColor,
        disabledContainerColor = disabledContainerColor ?: this.disabledContainerColor,
        disabledContentColor = disabledContentColor ?: this.disabledContentColor
    )

    companion object {
        val Default: SelectableButtonColors
            @Composable
            get() = SelectableButtonColors(
                containerColor = LucyTheme.colors.neutral10,
                contentColor = LucyTheme.colors.neutral100,
                selectedContainerColor = LucyTheme.colors.primarySurface,
                selectedContentColor = LucyTheme.colors.neutral100,
                disabledContainerColor = LucyTheme.colors.neutral10,
                disabledContentColor = LucyTheme.colors.neutral60
            )
    }
}
