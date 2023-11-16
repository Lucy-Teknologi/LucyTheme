package app.lucys.lib.lucytheme.ui.molecule.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import app.lucys.lib.lucytheme.ui.atom.button.LucySelectableButton
import app.lucys.lib.lucytheme.ui.atom.button.SelectableButtonColors

/**
 * A selectable button with predefined border stroke that changes
 * depending on selected state.
 *
 * @param onClick function to execute when item is clicked
 * @param modifier the composable modifier
 * @param selected highlights the item if true
 * @param enabled enabled / disabled state
 * @param colors color states for the composable
 * @param contentPadding padding between the content and the borders
 * @param shape the shape of the button
 * @param content the content of the button
 *
 * @see SelectableButtonColors
 * @see LucySelectableButton
 */
@Composable
fun LucyChip(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean,
    enabled: Boolean = true,
    colors: SelectableButtonColors = LucyChipDefaults.defaultColors(),
    contentPadding: PaddingValues = LucyChipDefaults.ContentPadding,
    shape: Shape = LucyChipDefaults.Shape,
    contentHorizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable RowScope.() -> Unit
) {
    val borderStroke by LucyChipDefaults.borderStroke(selected = selected)

    LucySelectableButton(
        onClick = onClick,
        modifier = modifier,
        border = borderStroke,
        contentPadding = contentPadding,
        colors = colors,
        shape = shape,
        selected = selected,
        enabled = enabled,
        contentHorizontalAlignment = contentHorizontalAlignment,
        content = content,
    )
}
