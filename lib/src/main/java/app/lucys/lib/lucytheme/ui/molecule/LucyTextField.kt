package app.lucys.lib.lucytheme.ui.molecule

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

@Composable
fun LucyTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    value: String,
    enabled: Boolean = true,
    textStyle: TextStyle = LucyTheme.typography.mediumBody,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.lucyTextFieldColors(),
    singleLine: Boolean = false,
    readOnly: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
) {
    OutlinedTextField(
        onValueChange = onValueChange,
        label = label,
        value = value,
        modifier = modifier,
        enabled = enabled,
        textStyle = textStyle,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        maxLines = maxLines,
        keyboardActions = keyboardActions,
        shape = shape,
        colors = colors,
        readOnly = readOnly,
    )
}

@Preview
@Composable
fun PreviewLucyTextField() {
    LucyTheme {
        LucyTextField(
            modifier = Modifier.padding(16.dp),
            label = {
                Text(text = "This Label", style = TextStyle(fontSize = 12.sp))
            },
            onValueChange = { value ->
                print(value)
            },
            value = ""
        )
    }
}
