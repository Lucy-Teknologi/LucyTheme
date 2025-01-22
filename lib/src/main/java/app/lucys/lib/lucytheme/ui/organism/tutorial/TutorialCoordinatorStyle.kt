package app.lucys.lib.lucytheme.ui.organism.tutorial

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
class TutorialCoordinatorStyle constructor(
    val title: TextStyle,
    val counter: TextStyle,
    val description: TextStyle,
) {
    fun copy(
        title: TextStyle? = null,
        counter: TextStyle? = null,
        content: TextStyle? = null,
    ): TutorialCoordinatorStyle = TutorialCoordinatorStyle(
        title = title ?: this.title,
        counter = counter ?: this.counter,
        description = content ?: this.description,
    )
}