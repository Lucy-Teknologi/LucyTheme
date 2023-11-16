package app.lucys.lib.lucytheme.ui.molecule.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme
import app.lucys.lib.lucytheme.ui.atom.button.SelectableButtonColors

object LucyChipDefaults {
    private val horizontalPadding = 12.dp
    private val verticalPadding = 12.dp

    /**
     * The default content padding used by [LucyChip]
     */
    val ContentPadding: PaddingValues = PaddingValues(
        horizontal = horizontalPadding,
        vertical = verticalPadding,
    )

    /**
     * The default shape of [LucyChip]
     */
    val Shape: Shape = RoundedCornerShape(8.dp)

    /**
     * The default button colors of [LucyChip]
     */
    @Composable
    fun defaultColors(): SelectableButtonColors = SelectableButtonColors.Default

    /**
     * The border stroke of [LucyChip] when selected is true
     */
    private val borderStrokeSelected: BorderStroke
        @Composable get() = BorderStroke(
            width = 1.dp,
            color = LucyTheme.colors.primaryBorder,
        )

    /**
     * The border stroke of [LucyChip] when selected is false
     */
    private val borderStrokeDefault: BorderStroke
        @Composable get() = BorderStroke(
            width = 1.dp,
            color = LucyTheme.colors.neutral40,
        )

    /**
     * Return a [BorderStroke] corresponding to the [selected] state
     *
     * @param selected the selected state of the chip
     */
    @Composable
    internal fun borderStroke(selected: Boolean): State<BorderStroke> {
        return rememberUpdatedState(
            when (selected) {
                true -> borderStrokeSelected
                false -> borderStrokeDefault
            }
        )
    }
}
