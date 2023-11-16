package app.lucys.lib.lucytheme.ui.molecule.timelapse

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.concurrent.timer
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
fun LucyTimelapse(
    key: Any?,
    initialTime: Instant,
    modifier: Modifier = Modifier,
    shape: Shape = LucyTimelapseDefaults.Shape,
    contentPadding: PaddingValues = LucyTimelapseDefaults.ContentPadding,
    colors: LucyTimelapseColors = LucyTimelapseDefaults.defaultColors(),
    strategy: LucyTimelapseStrategy = LucyTimelapseDefaults.Strategy,
    textStyle: TextStyle = LucyTimelapseDefaults.TextStyle,
) {
    var lapse by remember { mutableStateOf(Duration.ZERO) }
    val label by remember {
        derivedStateOf {
            lapse.toComponents { m, s, _ -> String.format("%02d:%02d", m, s) }
        }
    }

    val state by remember { derivedStateOf { strategy(lapse) } }

    val containerColor by colors.containerColor(state = state)
    val animatedContainerColor by animateColorAsState(
        containerColor, label = "timelapse_container"
    )

    val contentColor by colors.contentColor(state = state)
    val animatedContentColor by animateColorAsState(
        contentColor, label = "timelapse_content"
    )

    val borderColor by colors.borderColor(state = state)
    val animatedBorderColor by animateColorAsState(
        borderColor, label = "timelapse_border"
    )

    DisposableEffect(key1 = key ?: initialTime) {
        lapse = Clock.System.now().minus(initialTime)

        val timer = timer(initialDelay = 100L, period = 1_000L) {
            lapse = lapse.plus(1.seconds)
        }
        onDispose { timer.cancel() }
    }

    Surface(
        color = animatedContainerColor,
        modifier = modifier
            .border(1.dp, color = animatedBorderColor, shape = shape)
    ) {
        Text(
            text = label,
            style = textStyle,
            color = animatedContentColor,
            modifier = Modifier.padding(contentPadding)
        )
    }
}


@Preview
@Composable
fun LucyTimelapse_Preview() {
    LucyTheme {
        LucyTimelapse(
            key = null,
            initialTime = Clock.System.now().minus(590.seconds),
            modifier = Modifier.padding(12.dp),
        )
    }
}