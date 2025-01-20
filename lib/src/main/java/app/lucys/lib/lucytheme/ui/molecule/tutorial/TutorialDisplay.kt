package app.lucys.lib.lucytheme.ui.molecule.tutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.organism.TutorialCoordinatorColors
import app.lucys.lib.lucytheme.ui.organism.TutorialCoordinatorStyle
import app.lucys.lib.lucytheme.ui.theme.LucyTheme
import app.lucys.lib.lucytheme.ui.util.TutorialTarget
import kotlin.math.roundToInt

@Composable
fun BoxWithConstraintsScope.TutorialDisplay(
    modifier: Modifier = Modifier,
    cap: Int,
    target: TutorialTarget,
    colors: TutorialCoordinatorColors,
    style: TutorialCoordinatorStyle,
) {
    val density = LocalDensity.current
    var offset: IntOffset by remember { mutableStateOf(IntOffset.Zero) }

    Card(
        modifier = modifier
            .sizeIn(maxWidth = 220.dp, maxHeight = 120.dp)
            .onPlaced { layout ->
                val screenWidthPx = constraints.maxWidth
                val screenHeightPx = constraints.maxHeight

                val cardWidthPx = layout.size.width
                val cardHeightPx = layout.size.height

                val targetBounds = target.coordinates.boundsInWindow()
                val targetCenterX = targetBounds.center.x
                val targetLeftPx = targetBounds.left
                val targetRightPx = targetBounds.right
                val targetBottomPx = targetBounds.bottom
                val targetTopPx = targetBounds.top

                val cardRightPxOnCenter = targetCenterX + (cardWidthPx / 2)
                val cardLeftPxOnCenter = (cardWidthPx / 2) - targetCenterX

                val verticalPadding = with(density) { 16.dp.toPx() }

                val offsetX: Int = if (cardRightPxOnCenter > screenWidthPx) {
                    // Card overflows to the right when placed at center of target
                    (targetRightPx - cardWidthPx).roundToInt()
                } else if (cardLeftPxOnCenter > 0 && cardRightPxOnCenter > targetLeftPx) {
                    // Card overflows to the left when placed at the center of target
                    val minPadding = with(density) { 8.dp.toPx() }

                    val result = targetLeftPx
                        .minus(with(density) { 8.dp.toPx() })
                        .roundToInt()

                    if (result <= minPadding) minPadding.roundToInt() else result
                } else {
                    // Card does not overflow horizontally when placed at center of target
                    (targetCenterX - (cardWidthPx / 2)).roundToInt()
                }

                val offsetY: Int = if (cardHeightPx + targetBottomPx > screenHeightPx) {
                    // Card overflows to the bottom if placed below target
                    (targetTopPx - cardHeightPx - verticalPadding).roundToInt()
                } else {
                    (targetBottomPx + verticalPadding).roundToInt()
                }
                offset = IntOffset(offsetX, offsetY)
            }
            .offset { offset },
        colors = CardDefaults.cardColors(
            containerColor = LucyTheme.colors.neutral10,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${target.index + 1}/$cap",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = colors.counterColor,
            )
            Text(
                text = target.title,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                color = colors.titleColor,
            )
            Text(
                text = target.description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                maxLines = 2,
                color = colors.contentColor,
            )
        }
    }
}