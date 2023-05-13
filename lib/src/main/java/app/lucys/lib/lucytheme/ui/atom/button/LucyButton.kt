package app.lucys.lib.lucytheme.ui.atom.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * An override of [Button] using [LucyTheme]. This represents a
 * primary button in the figma design.
 *
 * @see Button
 * @see LucyTheme
 * @see <a href = "https://www.figma.com/file/LE07PCqzCfAh9gpjkovRq2"> Design Specs </a>
 */
@Composable
fun LucyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LucyTheme.typography.largeButton,
    shape: Shape = LucyButtonDefaults.shape,
    colors: ButtonColors = LucyButtonDefaults.primaryButtonColors(),
    elevation: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    border: LucyButtonBorderStroke = LucyButtonDefaults.baseBorderStroke,
    contentPadding: PaddingValues = LucyButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.sizeIn(
            minWidth = LucyButtonDefaults.MinWidth,
            minHeight = LucyButtonDefaults.MinHeight,
        ),
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = BorderStroke(
            width = border.borderSize(enabled = enabled).value,
            color = border.borderColor(enabled = enabled).value
        ),
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = {
            ProvideTextStyle(value = textStyle) {
                content()
            }
        }
    )
}

/**
 * An override of [Button] using [LucyTheme]. This represents a
 * secondary button in the figma design.
 *
 * @see Button
 * @see LucyTheme
 * @see <a href = "https://www.figma.com/file/LE07PCqzCfAh9gpjkovRq2"> Design Specs </a>
 */
@Composable
fun LucySecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LucyTheme.typography.largeButton,
    shape: Shape = LucyButtonDefaults.shape,
    colors: ButtonColors = LucyButtonDefaults.secondaryButtonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: LucyButtonBorderStroke = LucyButtonDefaults.secondaryBorderStroke,
    contentPadding: PaddingValues = LucyButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    LucyButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        textStyle = textStyle,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

/**
 * An override of [Button] using [LucyTheme]. This represents an
 * Outline button in the figma design.
 *
 * @see Button
 * @see LucyTheme
 * @see <a href = "https://www.figma.com/file/LE07PCqzCfAh9gpjkovRq2"> Design Specs </a>
 */
@Composable
fun LucyOutlineButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LucyTheme.typography.largeButton,
    shape: Shape = LucyButtonDefaults.shape,
    colors: ButtonColors = LucyButtonDefaults.outlineButtonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: LucyButtonBorderStroke = LucyButtonDefaults.outlineBorderStroke,
    contentPadding: PaddingValues = LucyButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    LucyButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        textStyle = textStyle,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

/**
 * An override of [Button] using [LucyTheme]. This represents a
 * danger button in the figma design.
 *
 * @see Button
 * @see LucyTheme
 * @see <a href = "https://www.figma.com/file/LE07PCqzCfAh9gpjkovRq2"> Design Specs </a>
 */
@Composable
fun LucyDangerButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LucyTheme.typography.largeButton,
    shape: Shape = LucyButtonDefaults.shape,
    colors: ButtonColors = LucyButtonDefaults.dangerButtonColors(),
    elevation: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    border: LucyButtonBorderStroke = LucyButtonDefaults.baseBorderStroke,
    contentPadding: PaddingValues = LucyButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    LucyButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        textStyle = textStyle,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}

/**
 * An override of [Button] using [LucyTheme]. This represents a
 * text button in the figma design.
 *
 * @see Button
 * @see LucyTheme
 * @see <a href = "https://www.figma.com/file/LE07PCqzCfAh9gpjkovRq2"> Design Specs </a>
 */
@Composable
fun LucyTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = LucyTheme.typography.largeButton,
    shape: Shape = LucyButtonDefaults.shape,
    colors: ButtonColors = LucyButtonDefaults.textButtonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: LucyButtonBorderStroke = LucyButtonDefaults.textBorderStroke,
    contentPadding: PaddingValues = LucyButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    LucyButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        textStyle = textStyle,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )
}
