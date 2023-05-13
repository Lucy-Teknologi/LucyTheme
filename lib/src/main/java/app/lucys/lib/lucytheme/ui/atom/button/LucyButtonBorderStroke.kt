package app.lucys.lib.lucytheme.ui.atom.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Immutable
class LucyButtonBorderStroke(
    private val enabledBorderColor: Color,
    private val disabledBorderColor: Color,
    private val enabledBorderSize: Dp,
    private val disabledBorderSize: Dp
) {
    /**
     * Represents the color of the border, depending on [enabled]
     *
     * @param enabled whether the button is enabled
     */
    @Composable
    internal fun borderColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) enabledBorderColor else disabledBorderColor)
    }

    /**
     * Represents the size of the border, depending on [enabled]
     *
     * @param enabled whether the button is enabled
     */
    @Composable
    internal fun borderSize(enabled: Boolean): State<Dp> {
        return rememberUpdatedState(if (enabled) enabledBorderSize else disabledBorderSize)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is LucyButtonBorderStroke) return false

        if (enabledBorderColor != other.enabledBorderColor) return false
        if (disabledBorderColor != other.disabledBorderColor) return false
        if (enabledBorderSize != other.enabledBorderSize) return false
        if (disabledBorderSize != other.disabledBorderSize) return false

        return true
    }

    override fun hashCode(): Int {
        var result = enabledBorderColor.hashCode()
        result = 31 * result + disabledBorderColor.hashCode()
        result = 31 * result + enabledBorderSize.hashCode()
        result = 31 * result + disabledBorderSize.hashCode()
        return result
    }
}
