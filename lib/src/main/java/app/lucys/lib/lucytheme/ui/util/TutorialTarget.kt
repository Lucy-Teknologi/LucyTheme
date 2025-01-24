package app.lucys.lib.lucytheme.ui.util

import androidx.compose.ui.layout.LayoutCoordinates

/**
 * A model for the tutorial target.
 * @param index The order of which the target should be displayed, must start from 0.
 * @param title The title of the tutorial.
 * @param description The description of the tutorial.
 * @param coordinates The coordinates of the view to highlight.
 */
class TutorialTarget(
    val index: Int,
    val title: String,
    val description: String,
    val coordinates: LayoutCoordinates,
    val onClick: () -> Unit,
    val key: Int? = null,
)
