package app.lucys.lib.lucytheme.ui.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

object TutorialCoordinatorDefaults {

    val MaxWidth = 220.dp

    @Composable
    fun colors(
        backgroundColor: Color = LucyTheme.colors.neutral10,
        contentColor: Color = LucyTheme.colors.neutral80,
        titleColor: Color = LucyTheme.colors.neutral100,
        counterColor: Color = LucyTheme.colors.neutral100,
    ): TutorialCoordinatorColors =
        TutorialCoordinatorColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            titleColor = titleColor,
            counterColor = counterColor,
        )

    @Composable
    fun style(
        title: TextStyle = LucyTheme.typography.smallHeadline,
        counter: TextStyle = LucyTheme.typography.smallBody,
        content: TextStyle = LucyTheme.typography.smallBody,
    ): TutorialCoordinatorStyle =
        TutorialCoordinatorStyle(
            title = title,
            counter = counter,
            content = content,
        )

}