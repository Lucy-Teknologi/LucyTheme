package app.lucys.lib.lucytheme.ui.molecule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

typealias LucyTimelapseStrategy = (Duration) -> LucyTimelapseState

object LucyTimelapseDefaults {
    private val horizontalPadding = 12.dp
    private val verticalPadding = 4.dp

    val ContentPadding = PaddingValues(horizontalPadding, verticalPadding)

    val Shape = RoundedCornerShape(8.dp)

    val Strategy: LucyTimelapseStrategy = { duration ->
        when {
            duration > 20.minutes -> LucyTimelapseState.DANGER
            duration > 10.minutes -> LucyTimelapseState.WARNING
            else -> LucyTimelapseState.NORMAL
        }
    }

    val TextStyle : TextStyle
        @Composable
        get() = LucyTheme.typography.xSmallHeadline

    @Composable
    fun defaultColors(
        defaultContainerColor: Color = LucyTheme.colors.infoSurface,
        defaultContentColor: Color = LucyTheme.colors.infoMain,
        defaultBorderColor: Color = LucyTheme.colors.infoBorder,
        warningContainerColor: Color = LucyTheme.colors.dangerSurface,
        warningContentColor: Color = LucyTheme.colors.dangerMain,
        warningBorderColor: Color = LucyTheme.colors.dangerBorder,
        dangerContainerColor: Color = LucyTheme.colors.errorSurface,
        dangerContentColor: Color = LucyTheme.colors.errorMain,
        dangerBorderColor: Color = LucyTheme.colors.errorBorder ,
    ): LucyTimelapseColors = LucyTimelapseColors(
        defaultContainerColor = defaultContainerColor,
        defaultContentColor = defaultContentColor,
        defaultBorderColor = defaultBorderColor,
        warningContainerColor = warningContainerColor,
        warningContentColor = warningContentColor,
        warningBorderColor = warningBorderColor,
        dangerContainerColor = dangerContainerColor,
        dangerContentColor = dangerContentColor,
        dangerBorderColor = dangerBorderColor,
    )

}