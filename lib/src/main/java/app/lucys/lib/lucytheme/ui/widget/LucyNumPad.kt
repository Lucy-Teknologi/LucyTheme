package app.lucys.lib.lucytheme.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.atom.button.LucyTextButton
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * A Number pad widget that can be used to enter numbers.
 * @param modifier The modifier to be applied to the layout.
 * @param onNumberClicked The callback to be invoked when a number is clicked.
 * @param onClearClicked The callback to be invoked when the clear button is clicked.
 * @param onBackspaceClicked The callback to be invoked when the backspace button is clicked.
 * @param backgroundColor The background color of the widget.
 * @param verticalArrangement The vertical arrangement of the widget.
 * @param horizontalArrangement The horizontal arrangement of the widget.
 * @param contentPadding The padding to be applied to the content of the widget.
 * @param textStyle The text style to be applied to the text of the widget.
 *
 * @sample app.lucys.lib.ui.component.widget.LucyNumPadPreview
 */
@Composable
fun LucyNumPad(
    modifier: Modifier = Modifier,
    onNumberClicked: (String) -> Unit,
    onClearClicked: () -> Unit,
    onBackspaceClicked: () -> Unit,
    backgroundColor: Color = LucyTheme.colors.neutral20,
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(16.dp),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
    textStyle: TextStyle = LucyTheme.typography.largeTitle.copy(
        color = LucyTheme.colors.neutral100
    ),
) {
    LazyVerticalGrid(
        modifier = modifier.background(color = backgroundColor),
        columns = GridCells.Fixed(count = 3),
        verticalArrangement = verticalArrangement,
        horizontalArrangement = horizontalArrangement,
        contentPadding = contentPadding,
    ) {
        items(9) { value ->
            LucyTextButton(
                onClick = { onNumberClicked(value.plus(1).toString()) },
                modifier = Modifier.sizeIn(minHeight = 64.dp),
                shape = CircleShape,
                textStyle = textStyle,
            ) {
                Text(text = value.plus(1).toString())
            }
        }
        item {
            LucyTextButton(
                onClick = onClearClicked,
                modifier = Modifier.sizeIn(minHeight = 64.dp),
                shape = CircleShape,
                textStyle = textStyle,
            ) {
                Text(text = "C")
            }
        }
        item {
            LucyTextButton(
                onClick = { onNumberClicked("0") },
                modifier = Modifier.sizeIn(minHeight = 64.dp),
                shape = CircleShape,
                textStyle = textStyle,
            ) {
                Text(text = "0")
            }
        }
        item {
            LucyTextButton(
                onClick = onBackspaceClicked,
                modifier = Modifier.sizeIn(minHeight = 64.dp),
                shape = CircleShape,
                textStyle = textStyle,
            ) {
                Text(text = "Back", overflow = TextOverflow.Ellipsis, maxLines = 1)
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 720)
@Composable
private fun PreviewLucyNumPad() {
    LucyTheme {
        LucyNumPad(
            modifier = Modifier.fillMaxWidth(),
            onNumberClicked = { },
            onBackspaceClicked = { },
            onClearClicked = { }
        )
    }
}
