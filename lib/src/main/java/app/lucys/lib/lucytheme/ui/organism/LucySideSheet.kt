package app.lucys.lib.lucytheme.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme
import app.lucys.lib.lucytheme.ui.widget.appbar.LucyElevatedAppBar

@Composable
fun LucySideSheet(
    title: @Composable () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    borderWidth: Dp = 1.dp,
    maxWidth: Dp = LucySideSheetDefaults.MaxWidth,
    dividerColor: Color = LucySideSheetDefaults.DividerColor,
    backgroundColor: Color = LucyTheme.colors.neutral10,
    shape: Shape = RectangleShape,
    contentPadding: PaddingValues = LucySideSheetDefaults.ContentPadding,
) {
    Surface(
        modifier = modifier
            .widthIn(max = maxWidth)
            .drawBehind {
                drawLine(
                    color = dividerColor,
                    start = Offset(0f, 0f),
                    end = Offset(x = 0f, this.size.height),
                    strokeWidth = borderWidth.toPx(),
                )
            },
        color = backgroundColor,
        shape = shape,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            title()
            content()
        }
    }
}

@Composable
fun LucyBorderlessSideSheet(
    title: @Composable () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = LucyTheme.colors.neutral10,
    shape: Shape = RectangleShape,
    contentPadding: PaddingValues = LucySideSheetDefaults.ContentPadding,
    maxWidth: Dp = LucySideSheetDefaults.MaxWidth,
) {
    Surface(
        modifier = modifier.widthIn(max = maxWidth),
        color = backgroundColor,
        shape = shape,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            title()
            content()
        }
    }
}

@Composable
fun LucySideSheetTitle(
    title: @Composable () -> Unit,
    close: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    spacing: Dp = LucySideSheetDefaults.HeaderItemSpacing,
    textStyle: TextStyle = LucyTheme.typography.mediumHeadline,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spacing),
    ) {
        ProvideTextStyle(value = textStyle) {
            Box(modifier = Modifier.weight(1f), content = { title() })
        }
        close()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = "spec:width=1280dp,height=800dp,dpi=240", showBackground = true)
@Composable
internal fun LucySideSheet_Preview() {
    LucyTheme(isMobile = false) {
        Row(
            Modifier
                .fillMaxSize()
                .background(LucyTheme.colors.neutral10)
        ) {
            Scaffold(
                modifier = Modifier.weight(1f),
                topBar = {
                    LucyElevatedAppBar(
                        title = { Text("App Bar") },
                        containerColor = LucyTheme.colors.neutral10,
                    )
                },
            ) { padding ->
                Text(
                    text = "Content",
                    modifier = Modifier
                        .padding(padding)
                        .padding(top = 12.dp, start = 12.dp),
                )
            }
            LucySideSheet(
                title = {
                    LucySideSheetTitle(
                        modifier = Modifier
                            .padding(bottom = LucySideSheetDefaults.HeaderPadding),
                        title = { Text("Filter") },
                        close = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "close"
                                )
                            }
                        },
                    )
                },
                content = {
                    Text("Content")
                }
            )
        }
    }
}