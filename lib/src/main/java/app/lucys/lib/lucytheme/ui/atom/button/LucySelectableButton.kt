package app.lucys.lib.lucytheme.ui.atom.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * A single selectable button.
 *
 * @param onClick function to execute when item is clicked
 * @param modifier the composable modifier
 * @param enabled enabled / disabled state
 * @param selected highlights the item if true
 * @param textStyle text style for the text
 * @param contentPadding padding between the content and the borders
 * @param colors color states for the composable
 * @param border borders for the composable
 * @param shape shape of the border
 * @param content the content of the button
 *
 * @see SelectableButtonColors
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LucySelectableButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = false,
    textStyle: TextStyle = LucyTheme.typography.smallButton,
    contentPadding: PaddingValues = LucyButtonDefaults.ContentPadding,
    colors: SelectableButtonColors = SelectableButtonColors.Default,
    border: BorderStroke? = null,
    shape: Shape = RectangleShape,
    contentHorizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable RowScope.() -> Unit
) {
    val containerColors by colors.containerColor(enabled = enabled, selected = selected)
    val contentColors by colors.contentColor(enabled = enabled, selected = selected)

    val animatedContainerColor by animateColorAsState(
        targetValue = containerColors,
        animationSpec = tween(durationMillis = 200, easing = LinearEasing)
    )
    val animatedContentColor by animateColorAsState(
        targetValue = contentColors,
        animationSpec = tween(durationMillis = 200, easing = LinearEasing)
    )

    ProvideTextStyle(value = textStyle) {
        Surface(
            modifier = modifier.animateContentSize(),
            onClick = onClick,
            color = animatedContainerColor,
            contentColor = animatedContentColor,
            border = border,
            shape = shape
        ) {
            Row(
                modifier = Modifier.padding(contentPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    ButtonDefaults.IconSpacing,
                    alignment = contentHorizontalAlignment,
                )
            ) {
                content()
            }
        }
    }
}
