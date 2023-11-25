package app.lucys.lib.lucytheme.ui.molecule.timelapse

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color

@Immutable
class LucyTimelapseColors internal constructor(
    private val defaultContainerColor: Color,
    private val defaultContentColor: Color,
    private val defaultBorderColor: Color,
    private val warningContainerColor: Color,
    private val warningContentColor: Color,
    private val warningBorderColor: Color,
    private val dangerContainerColor: Color,
    private val dangerContentColor: Color,
    private val dangerBorderColor: Color,
) {

    @Composable
    internal fun containerColor(state: LucyTimelapseState): State<Color> = rememberUpdatedState(
        when (state) {
            LucyTimelapseState.NORMAL -> defaultContainerColor
            LucyTimelapseState.WARNING -> warningContainerColor
            LucyTimelapseState.DANGER -> dangerContainerColor
        }
    )

    @Composable
    internal fun contentColor(state: LucyTimelapseState): State<Color> = rememberUpdatedState(
        when (state) {
            LucyTimelapseState.NORMAL -> defaultContentColor
            LucyTimelapseState.WARNING -> warningContentColor
            LucyTimelapseState.DANGER -> dangerContentColor
        }
    )

    @Composable
    internal fun borderColor(state: LucyTimelapseState): State<Color> = rememberUpdatedState(
        when (state) {
            LucyTimelapseState.NORMAL -> defaultBorderColor
            LucyTimelapseState.WARNING -> warningBorderColor
            LucyTimelapseState.DANGER -> dangerBorderColor
        }
    )

}