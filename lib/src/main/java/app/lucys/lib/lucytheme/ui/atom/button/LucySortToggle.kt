package app.lucys.lib.lucytheme.ui.atom.button

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * A convenient composable for toggle sort buttons.
 *
 * @param modifier modifier for the wrapped text button
 * @param onClick callback for the button on click
 * @param title descriptive text besides the sort icon
 * @param ascending shows arrow upward icon when true, arrow downward icon otherwise
 * @param enabled enabled state of the button
 */
@Composable
fun LucySortToggle(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    ascending: Boolean = true,
    enabled: Boolean = true,
) {
    val rotation by animateFloatAsState(
        targetValue = if (ascending) 0f else 1f,
        animationSpec = tween(200, easing = EaseIn)
    )

    LucyTextButton(modifier = modifier, onClick = onClick, enabled = enabled) {
        Text(text = title, modifier = Modifier.padding(end = 8.dp))
        Icon(
            imageVector = Icons.Rounded.KeyboardArrowUp,
            contentDescription = "$title ascending $ascending",
            modifier = Modifier.rotate(180f * rotation)
        )
    }
}

@Preview
@Composable
fun PreviewSortToggle() {
    LucyTheme {
        LucySortToggle(
            onClick = { },
            title = "Sort",
            ascending = false,
        )
    }
}
