package app.lucys.lib.lucytheme.ui.molecule.textfield

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * Default [TextFieldColors] for [LucyTextField].
 * @see LucyTextField
 *
 * Todo: Add more colors
 */
@Composable
fun OutlinedTextFieldDefaults.lucyTextFieldColors(
    textColor: Color = LucyTheme.colors.neutral100,
    unfocusedTextColor: Color = LucyTheme.colors.neutral80,
    disabledTextColor: Color = LucyTheme.colors.neutral60,
    cursorColor: Color = LucyTheme.colors.primaryHover,
    errorCursorColor: Color = LucyTheme.colors.errorHover,
    focusedLeadingIconColor: Color = LucyTheme.colors.primaryMain,
    disabledLeadingIconColor: Color = LucyTheme.colors.neutral60,
    unfocusedLeadingIconColor: Color = LucyTheme.colors.neutral70,
    errorLeadingIconColor: Color = LucyTheme.colors.neutral70,
    focusedTrailingIconColor: Color = LucyTheme.colors.neutral70,
    unfocusedTrailingIconColor: Color = LucyTheme.colors.neutral70,
    disabledTrailingIconColor: Color = LucyTheme.colors.neutral60,
    errorTrailingIconColor: Color = LucyTheme.colors.neutral70,
    containerColor: Color = Color.Transparent,
    focusedLabelColor: Color = LucyTheme.colors.neutral100,
    unfocusedLabelColor: Color = LucyTheme.colors.neutral60,
    disabledLabelColor: Color = LucyTheme.colors.neutral60,
    errorLabelColor: Color = LucyTheme.colors.neutral100,
    placeholderColor: Color = LucyTheme.colors.neutral60,
    disabledPlaceholderColor: Color = LucyTheme.colors.neutral60,
    focusedSupportingTextColor: Color = LucyTheme.colors.neutral60,
    unfocusedSupportingTextColor: Color = LucyTheme.colors.neutral60,
    disabledSupportingTextColor: Color = LucyTheme.colors.neutral60,
    errorSupportingTextColor: Color = LucyTheme.colors.neutral60,
    focusedBorderColor: Color = LucyTheme.colors.primaryMain,
    unfocusedBorderColor: Color = LucyTheme.colors.neutral40,
    disabledBorderColor: Color = LucyTheme.colors.neutral30,
    errorBorderColor: Color = LucyTheme.colors.errorMain,
    selectionColors: TextSelectionColors = TextSelectionColors(
        handleColor = LucyTheme.colors.primaryHover,
        backgroundColor = LucyTheme.colors.primarySurface,
    ),
): TextFieldColors {
    return colors(
        disabledTextColor = disabledTextColor,
        cursorColor = cursorColor,
        errorCursorColor = errorCursorColor,
        focusedLeadingIconColor = focusedLeadingIconColor,
        unfocusedLeadingIconColor = unfocusedLeadingIconColor,
        disabledLeadingIconColor = disabledLeadingIconColor,
        errorLeadingIconColor = errorLeadingIconColor,
        focusedTrailingIconColor = focusedTrailingIconColor,
        unfocusedTrailingIconColor = unfocusedTrailingIconColor,
        disabledTrailingIconColor = disabledTrailingIconColor,
        errorTrailingIconColor = errorTrailingIconColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unfocusedLabelColor,
        disabledLabelColor = disabledLabelColor,
        errorLabelColor = errorLabelColor,
        disabledPlaceholderColor = disabledPlaceholderColor,
        focusedSupportingTextColor = focusedSupportingTextColor,
        unfocusedSupportingTextColor = unfocusedSupportingTextColor,
        disabledSupportingTextColor = disabledSupportingTextColor,
        errorSupportingTextColor = errorSupportingTextColor,
        selectionColors = selectionColors,
        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unfocusedBorderColor,
        disabledBorderColor = disabledBorderColor,
        errorBorderColor = errorBorderColor,
        focusedTextColor = textColor,
        unfocusedTextColor = unfocusedTextColor,
        unfocusedPlaceholderColor = placeholderColor,
        errorPlaceholderColor = placeholderColor,
        focusedPlaceholderColor = placeholderColor,
        focusedContainerColor = containerColor,
    )
}
