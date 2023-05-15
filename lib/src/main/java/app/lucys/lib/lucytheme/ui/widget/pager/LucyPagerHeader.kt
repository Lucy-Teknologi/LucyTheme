package app.lucys.lib.lucytheme.ui.widget.pager

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.launch

/**
 * A header for [HorizontalPager] with lucy colors.
 * @param modifier The modifier to be applied to the layout.
 * @param pagerState The [PagerState] to be used.
 * @param pageCount The number of pages.
 * @param pageTitle The title builder of each page.
 *
 * @see HorizontalPager
 * @see LucyPagerHeaderDefaults
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LucyPagerHeader(
    modifier: Modifier = Modifier,
    colors: LucyPagerHeaderColors = LucyPagerHeaderDefaults.colors(),
    itemMinWidth: Dp = LucyPagerHeaderDefaults.MinWidth,
    itemMaxWidth: Dp = LucyPagerHeaderDefaults.MaxWidth,
    itemHeight: Dp = LucyPagerHeaderDefaults.MaxHeight,
    itemHighlightHeight: Dp = LucyPagerHeaderDefaults.HighlightHeight,
    pagerState: PagerState,
    pageCount: Int,
    pageTitle: @Composable (Int) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        for (page in 0 until pageCount) {
            LucyPagerTitle(
                modifier = Modifier.weight(1f),
                colors = colors,
                itemMaxWidth = itemMaxWidth,
                itemMinWidth = itemMinWidth,
                itemMaxHeight = itemHeight,
                itemMinHeight = itemHeight,
                itemHighlightHeight = itemHighlightHeight,
                isSelected = pagerState.currentPage == page,
                onTap = { coroutineScope.launch { pagerState.animateScrollToPage(page) } },
                title = { pageTitle(page) },
            )
        }
    }
}

@Composable
private fun LucyPagerTitle(
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: LucyPagerHeaderColors = LucyPagerHeaderDefaults.colors(),
    itemMinWidth: Dp = LucyPagerHeaderDefaults.MinWidth,
    itemMaxWidth: Dp = LucyPagerHeaderDefaults.MaxWidth,
    itemMinHeight: Dp = LucyPagerHeaderDefaults.MinHeight,
    itemMaxHeight: Dp = LucyPagerHeaderDefaults.MaxHeight,
    itemHighlightHeight: Dp = LucyPagerHeaderDefaults.HighlightHeight,
    isSelected: Boolean,
    onTap: () -> Unit,
    title: @Composable () -> Unit,
) {
    val rememberColor by colors.contentColor(selected = isSelected)
    val animatedColor by animateColorAsState(
        targetValue = rememberColor,
        animationSpec = tween(durationMillis = 300, easing = EaseInOut),
    )

    val rememberHighlightColor by colors.highlightColor(selected = isSelected)
    val animatedHighlightColor by animateColorAsState(
        targetValue = rememberHighlightColor,
        animationSpec = tween(durationMillis = 300, easing = EaseInOut),
    )

    Box(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                onClick = onTap,
            )
            .sizeIn(
                minWidth = itemMinWidth,
                maxWidth = itemMaxWidth,
                minHeight = itemMinHeight,
                maxHeight = itemMaxHeight,
            ),
        contentAlignment = Alignment.Center,
    ) {
        ProvideTextStyle(
            value = MaterialTheme
                .typography
                .headlineSmall
                .copy(color = animatedColor)
        ) {
            title()
        }

        Box(
            modifier = Modifier
                .sizeIn(minWidth = itemMinWidth / 2, maxWidth = itemMaxWidth / 2)
                .height(itemHighlightHeight)
                .background(color = animatedHighlightColor)
                .align(Alignment.BottomCenter),
        )
    }
}