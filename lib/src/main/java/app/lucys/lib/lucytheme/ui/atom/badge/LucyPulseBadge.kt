package app.lucys.lib.lucytheme.ui.atom.badge

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.atom.images.LucyFilledIcon
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

@Composable
fun LucyPulseBadge(
    modifier: Modifier = Modifier,
    color: Color = LucyTheme.colors.primaryMain,
    content: @Composable () -> Unit = {},
) {
    val transition = rememberInfiniteTransition()
    val scaleAnimation by transition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1.6f,
        animationSpec = infiniteRepeatable(animation = tween(durationMillis = 1500))
    )
    val colorAnimation by transition.animateColor(
        initialValue = color,
        targetValue = color.copy(alpha = 0f),
        animationSpec = infiniteRepeatable(animation = tween(durationMillis = 1500))
    )

    Box(
        modifier = modifier
            .defaultMinSize(minWidth = 16.dp, minHeight = 16.dp)
            .drawBehind({
                val canvasSize = size
                val radius = canvasSize.maxDimension / 2

                drawCircle(
                    color = colorAnimation,
                    radius = radius * scaleAnimation,
                    center = center,
                )

                drawCircle(color = color, radius = radius, center = center)
            }),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LucyPulseBadgePreview() {
    LucyTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LucyPulseBadge {
//                Text(
//                    modifier = Modifier.padding(4.dp),
//                    text = "1",
//                    color = LucyTheme.colors.neutral10,
//                    style = LucyTheme.typography.smallBody,
//                )

                Icon(
                    modifier = Modifier.size(24.dp).padding(4.dp),
                    painter = painterResource(LucyFilledIcon.Bell.resourceId),
                    contentDescription = null,
                    tint = LucyTheme.colors.neutral10,
                )
            }
        }
    }
}
