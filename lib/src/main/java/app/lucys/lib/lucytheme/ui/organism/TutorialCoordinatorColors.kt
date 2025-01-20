package app.lucys.lib.lucytheme.ui.organism

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
class TutorialCoordinatorColors constructor(
    val backgroundColor: Color,
    val titleColor: Color,
    val contentColor: Color,
    val counterColor: Color,
) {
    fun copy(
        backgroundColor: Color = this.backgroundColor,
        titleColor: Color = this.titleColor,
        contentColor: Color = this.contentColor,
        counterColor: Color = this.counterColor,
    ): TutorialCoordinatorColors =
        TutorialCoordinatorColors(
            backgroundColor = backgroundColor,
            titleColor = titleColor,
            contentColor = contentColor,
            counterColor = counterColor,
        )

    override fun hashCode(): Int {
        var result = backgroundColor.hashCode()
        result = 31 * result + titleColor.hashCode()
        result = 31 * result + contentColor.hashCode()
        result = 31 * result + counterColor.hashCode()
        return result
    }
}