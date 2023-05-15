package app.lucys.lib.lucytheme.ui.widget.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.launch

/**
 * A header for [HorizontalPager] with lucy colors.
 * This is an override of [TabRow] with lucy colors
 *
 * @param modifier The modifier to be applied to the layout.
 * @param colors The [LucyPagerHeaderColors] to be used for this header.
 * @param itemHeight The height of each item in the header.
 * @param itemHighlightHeight The height of the highlight.
 * @param pagerState The [PagerState] to be used for this header.
 * @param pageCount The number of pages in the pager.
 * @param divider The divider to be used below the header.
 * @param pageTitle The title composable to be used for each page.
 *
 * @see TabRow
 * @see HorizontalPager
 * @see LucyPagerHeaderDefaults
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LucyPagerHeader(
    modifier: Modifier = Modifier,
    colors: LucyPagerHeaderColors = LucyPagerHeaderColors.Default,
    itemHeight: Dp = LucyPagerHeaderDefaults.MaxHeight,
    itemHighlightHeight: Dp = LucyPagerHeaderDefaults.HighlightHeight,
    pagerState: PagerState,
    pageCount: Int,
    divider: @Composable () -> Unit = { Divider() },
    pageTitle: @Composable (Int) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults
                .Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    height = itemHighlightHeight,
                    color = colors.selectedHighlightColor,
                )
        },
        divider = divider,
    ) {
        for (page in 0 until pageCount) {
            Tab(
                selected = page == pagerState.currentPage,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(page) } },
                modifier = Modifier.height(itemHeight),
                selectedContentColor = colors.selectedContentColor,
                unselectedContentColor = colors.contentColor,
            ) {
                pageTitle(page)
            }
        }
    }
}
