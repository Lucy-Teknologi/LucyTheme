package app.lucys.lib.lucytheme.ui.atom.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * An override of checkbox using lucy theme.
 *
 * @param checked whether this checkbox is checked or unchecked
 * @param onCheckedChange called when this checkbox is clicked. If `null`, then this checkbox will
 * not be interactable, unless something else handles its input events and updates its state.
 * @param modifier the [Modifier] to be applied to this checkbox
 * @param enabled controls the enabled state of this checkbox. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param colors [CheckboxColors] that will be used to resolve the colors used for this checkbox in
 * different states. See [CheckboxDefaults.colors].
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this checkbox. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this checkbox in different states.
 *
 * @see Checkbox
 */
@Composable
fun LucyCheckbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    Checkbox(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        enabled = enabled,
        colors = CheckboxDefaults.colors(
            checkedColor = LucyTheme.colors.primaryMain,
            disabledCheckedColor = LucyTheme.colors.neutral60,
            checkmarkColor = LucyTheme.colors.neutral10,
            disabledUncheckedColor = LucyTheme.colors.neutral40,
            uncheckedColor = LucyTheme.colors.neutral40,
        ),
        interactionSource = interactionSource,
    )
}

/**
 * An override of checkbox using lucy theme.
 * This checkbox has a label.
 * @param checked whether this checkbox is checked or unchecked
 * @param onCheckedChange called when this checkbox is clicked. If `null`, then this checkbox will
 * not be interactable, unless something else handles its input events and updates its state.
 * @param modifier the [Modifier] to be applied to this checkbox
 * @param enabled controls the enabled state of this checkbox. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this checkbox. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this checkbox in different states.
 * @param content the label of this checkbox
 */
@Composable
fun LucyCheckbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) {
    Row(
        modifier = modifier.clickable(
            enabled = enabled,
            onClick = { onCheckedChange?.invoke(!checked) },
            interactionSource = interactionSource,
            indication = ripple(),
        ),
        horizontalArrangement = Arrangement.spacedBy(LucyTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LucyCheckbox(
            checked = checked,
            onCheckedChange = null,
            enabled = enabled,
        )
        content()
    }
}
