package app.lucys.lib.lucytheme.ui.organism

import android.graphics.fonts.Font
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
class TutorialCoordinatorStyle constructor(
    val title: TextStyle,
    val counter: TextStyle,
    val content: TextStyle,
) {
    fun copy(
        title: TextStyle? = null,
        counter: TextStyle? = null,
        content: TextStyle? = null,
    ): TutorialCoordinatorStyle = TutorialCoordinatorStyle(
        title = title ?: this.title,
        counter = counter ?: this.counter,
        content = content ?: this.content,
    )
}