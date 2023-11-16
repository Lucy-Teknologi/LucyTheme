package app.lucys.lib.lucytheme.ui.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

fun ifComposable(
    condition: () -> Boolean,
    content: @Composable () -> Unit,
): (@Composable () -> Unit)? {
    if (condition()) return content
    return null
}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun IfComposable_Preview() {
    LucyTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(0.7f)
                    .background(LucyTheme.colors.dangerSurface),
            ) {
                Text("Content", modifier = Modifier.fillMaxWidth())
            }
            ifComposable({ true }) {
                Box(
                    modifier = Modifier
                        .weight(0.3f)
                        .background(LucyTheme.colors.dangerMain),
                ) {
                    Text("Other Content", modifier = Modifier.fillMaxWidth())
                }
            }?.invoke()
        }
    }
}