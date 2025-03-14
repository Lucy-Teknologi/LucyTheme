package app.lucys.lib.lucytheme.ui.organism.tutorial

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

object TutorialCoordinatorDefaults {

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
            description = content,
        )

}