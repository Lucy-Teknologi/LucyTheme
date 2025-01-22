package app.lucys.lib.lucytheme.ui.organism.draggable

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnchoredSwipeContainer(
    modifier: Modifier = Modifier,
    maxOffset: Dp = 120.dp,
    anchors: DraggableAnchors<AnchorEdge>? = null,
    onAnchored: (AnchorEdge) -> Unit = { },
    actions: @Composable RowScope.() -> Unit,
    content: @Composable () -> Unit,
) {
    val density = LocalDensity.current
    val state = remember {
        AnchoredDraggableState(
            initialValue = AnchorEdge.CENTER,
            anchors = anchors ?: DraggableAnchors {
                AnchorEdge.START at with(density) { -maxOffset.toPx() }
                AnchorEdge.CENTER at 0f
            },
            positionalThreshold = { distance -> distance * 0.5f },
            velocityThreshold = { with(density) { maxOffset.div(2).toPx() } },
            snapAnimationSpec = tween(durationMillis = 500),
            decayAnimationSpec = splineBasedDecay(density = density),
        )
    }

    LaunchedEffect(state.currentValue) {
        onAnchored(state.currentValue)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Row(
            modifier = Modifier.width(120.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            actions()
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
                .offset {
                    IntOffset(
                        x = state
                            .requireOffset()
                            .roundToInt(),
                        y = 0,
                    )
                }
                .anchoredDraggable(
                    state = state,
                    orientation = Orientation.Horizontal,
                    overscrollEffect = ScrollableDefaults.overscrollEffect(),
                ),
        ) {
            content()
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun AnchoredSwipeContainerPreview() {
    LucyTheme {
        AnchoredSwipeContainer(
            modifier = Modifier.padding(vertical = 16.dp),
            onAnchored = { edge ->
                Log.d("AnchoredSwipeContainer", "AnchoredSwipeContainerPreview: $edge")
            },
            actions = {
                IconButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(LucyTheme.colors.errorMain),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "delete",
                        tint = LucyTheme.colors.neutral10,
                    )
                }

                IconButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(LucyTheme.colors.infoMain),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = LucyTheme.colors.neutral10,
                    )
                }
            }
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RectangleShape,
                colors = CardDefaults.elevatedCardColors(
                    containerColor = LucyTheme.colors.infoSurface,
                    contentColor = LucyTheme.colors.neutral100,
                ),
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp)
                ) {
                    Text(
                        "This is the content",
                        style = LucyTheme.typography.smallHeadline,
                    )
                    Text(
                        "This is the description",
                        style = LucyTheme.typography.smallBody
                    )
                }
            }
        }
    }
}