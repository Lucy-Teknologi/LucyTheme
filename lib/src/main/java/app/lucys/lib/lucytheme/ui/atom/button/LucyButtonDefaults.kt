package app.lucys.lib.lucytheme.ui.atom.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * Default values for [LucyButton], [LucySecondaryButton], [LucyOutlineButton],
 * [LucyDangerButton], [LucyTextButton], [LucySelectableButton].
 *
 * @see ButtonDefaults
 */
object LucyButtonDefaults {
    private val ButtonHorizontalPadding = 16.dp
    private val ButtonVerticalPadding = 8.dp

    /**
     * The default content padding used by [LucyButton], [LucySecondaryButton], [LucyOutlineButton],
     * [LucyDangerButton], [LucyTextButton], [LucySelectableButton]
     */
    val ContentPadding = PaddingValues(
        horizontal = ButtonHorizontalPadding,
        vertical = ButtonVerticalPadding,
    )

    /**
     * The default minimal width of [LucyButton].
     *
     * It wraps content by default and relies on ContentPadding and external
     * modifier to create custom minimal size.
     */
    val MinWidth = 0.dp

    /**
     * The default minimal height of [LucyButton].
     *
     * It wraps content by default and relies on ContentPadding and external
     * modifier to create custom minimal size.
     */
    val MinHeight = 0.dp

    /**
     * Default shape of a [LucyButton]
     */
    val shape: Shape @Composable get() = RoundedCornerShape(8.dp)

    /**
     * Extensible button colors for all buttons
     */
    @Composable
    fun baseButtonColors(
        containerColor: Color,
        contentColor: Color,
        disabledContainerColor: Color = LucyTheme.colors.neutral40,
        disabledContentColor: Color = LucyTheme.colors.neutral60
    ) = ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    /**
     * Default button colors for [LucyButton]
     */
    @Composable
    fun primaryButtonColors(
        containerColor: Color = LucyTheme.colors.primaryMain,
        contentColor: Color = LucyTheme.colors.neutral10
    ) = baseButtonColors(
        containerColor = containerColor,
        contentColor = contentColor
    )

    /**
     * Default button colors for [LucySecondaryButton]
     */
    @Composable
    fun secondaryButtonColors(
        containerColor: Color = LucyTheme.colors.neutral10,
        contentColor: Color = LucyTheme.colors.primaryMain
    ) = baseButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )

    /**
     * Default button colors for [LucyOutlineButton]
     */
    @Composable
    fun outlineButtonColors(
        containerColor: Color = LucyTheme.colors.neutral10,
        contentColor: Color = LucyTheme.colors.neutral100
    ) = baseButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )

    /**
     * Default button colors for [LucyDangerButton]
     */
    @Composable
    fun dangerButtonColors(
        containerColor: Color = LucyTheme.colors.dangerMain,
        contentColor: Color = LucyTheme.colors.neutral10
    ) = baseButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )

    /**
     * Default button colors for [LucyTextButton]
     */
    @Composable
    fun textButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = LucyTheme.colors.primaryMain,
        disabledContainerColor: Color = Color.Transparent
    ) = baseButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor
    )

    val baseBorderStroke: LucyButtonBorderStroke
        @Composable
        get() = LucyButtonBorderStroke(
            enabledBorderColor = Color.Transparent,
            disabledBorderColor = LucyTheme.colors.neutral40,
            enabledBorderSize = 0.dp,
            disabledBorderSize = 1.dp
        )

    val secondaryBorderStroke: LucyButtonBorderStroke
        @Composable
        get() = LucyButtonBorderStroke(
            enabledBorderColor = LucyTheme.colors.primaryMain,
            disabledBorderColor = LucyTheme.colors.neutral40,
            enabledBorderSize = 1.dp,
            disabledBorderSize = 1.dp
        )

    val outlineBorderStroke: LucyButtonBorderStroke
        @Composable
        get() = LucyButtonBorderStroke(
            enabledBorderColor = LucyTheme.colors.neutral40,
            disabledBorderColor = LucyTheme.colors.neutral40,
            enabledBorderSize = 1.dp,
            disabledBorderSize = 1.dp
        )

    val textBorderStroke: LucyButtonBorderStroke
        @Composable
        get() = LucyButtonBorderStroke(
            enabledBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            enabledBorderSize = 0.dp,
            disabledBorderSize = 0.dp
        )
}
