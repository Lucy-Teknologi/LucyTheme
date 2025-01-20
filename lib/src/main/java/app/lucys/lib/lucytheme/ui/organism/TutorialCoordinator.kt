package app.lucys.lib.lucytheme.ui.organism

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.molecule.tutorial.TutorialDisplay
import app.lucys.lib.lucytheme.ui.util.TutorialTarget

@Composable
fun rememberTutorialState(
    initialVisible: Boolean
) = rememberSaveable(saver = TutorialState.saver) { TutorialState(initialVisible) }

@Composable
fun TutorialCoordinator(
    modifier: Modifier = Modifier,
    onDone: () -> Unit,
    state: TutorialState = rememberTutorialState(true),
    contentAlignment: Alignment = Alignment.TopStart,
    colors: TutorialCoordinatorColors = TutorialCoordinatorDefaults.colors(),
    style: TutorialCoordinatorStyle = TutorialCoordinatorDefaults.style(),
    content: @Composable TutorialScope.() -> Unit,
) {
    val scope = remember(state) { TutorialScope(state) }
    val density = LocalDensity.current

    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = contentAlignment,
    ) {
        content(scope)

        if (!state.isDone) {
            state.currentTarget?.let { target ->
                val targetBounds = target.coordinates.boundsInWindow()

                // Animate top left and bottom right corner offsets of target
                val topLeftCut = animateOffsetAsState(
                    targetBounds.topLeft.minus(
                        with(density) { Offset(8.dp.toPx(), 8.dp.toPx()) }
                    ),
                    label = "top left size"
                )
                val bottomRightCut = animateOffsetAsState(
                    target.coordinates.boundsInWindow().bottomRight.plus(
                        with(density) { Offset(8.dp.toPx(), 8.dp.toPx()) }
                    ),
                    label = "bottom right size"
                )

                TutorialScrim(
                    onDone = onDone,
                    onNext = state::next,
                    topLeftCut = topLeftCut.value,
                    bottomRightCut = bottomRightCut.value,
                    state = state,
                    target = target,
                )

                TutorialDisplay(
                    target = target,
                    cap = state.size,
                    colors = colors,
                    style = style,
                )
            }
        }
    }
}

@Composable
private fun TutorialScrim(
    onDone: () -> Unit,
    onNext: () -> Unit,
    topLeftCut: Offset,
    bottomRightCut: Offset,
    state: TutorialState,
    target: TutorialTarget,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .drawWithContent {
                drawContent()
                clipPath(
                    path = Path().apply {
                        addRoundRect(
                            RoundRect(
                                Rect(topLeftCut, bottomRightCut),
                                CornerRadius(8.dp.toPx(), 8.dp.toPx())
                            )
                        )
                    },
                    clipOp = ClipOp.Difference,
                ) {
                    drawRect(color = Color.Gray.copy(alpha = 0.4f), size = size)
                }
            }
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ) {
                target.onClick()
                onNext()

                if (state.isDone) onDone()
            },
    )
}

class TutorialScope(private val state: TutorialState) {

    fun Modifier.tutorialTarget(
        index: Int,
        title: String,
        description: String,
        onClick: () -> Unit = {},
    ): Modifier {
        return onPlaced { coordinate ->
            state.attach(
                TutorialTarget(
                    index = index,
                    title = title,
                    description = description,
                    coordinates = coordinate,
                    onClick = onClick,
                )
            )
        }
    }

}

@Stable
class TutorialState(
    initiallyVisible: Boolean,
    private var maxCount: Int? = null,
) {
    var isVisible by mutableStateOf(initiallyVisible)
    private var tapTargets = mutableStateMapOf<Int, TutorialTarget>()
    private var currentIndex by mutableIntStateOf(0)

    val currentTarget get() = tapTargets[currentIndex]

    val isDone: Boolean get() = currentIndex >= tapTargets.size || !isVisible

    val size: Int get() = maxCount ?: tapTargets.size

    fun reset() {
        isVisible = true
        currentIndex = 0
    }

    fun next() {
        currentIndex += 1
    }

    fun attach(target: TutorialTarget) {
        tapTargets[target.index] = target
    }

    fun skip() {
        isVisible = false
        currentIndex = tapTargets.size
    }

    companion object {
        val saver: Saver<TutorialState, *> = listSaver(
            save = { p -> listOf(p.currentIndex, p.isVisible) },
            restore = { p ->
                val index = p.first() as Int
                val visible = p[1] as Boolean
                TutorialState(visible).apply { currentIndex = index }
            }
        )
    }
}
