package app.lucys.lib.lucytheme.ui.widget.appbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.lucys.lib.lucytheme.ui.theme.LucyTheme

/**
 * A [TopAppBar] with Lucy's theme applied.
 * @param modifier The modifier to be applied to the component.
 * @param title The title to be displayed in the app bar.
 * @param navigationIcon The icon to be displayed at the start of the app bar.
 * @param actions The actions to be displayed at the end of the app bar.
 * @param scrollBehavior The scroll behavior to be applied to the app bar.
 * @param containerColor The color to be applied to the app bar's container.
 *
 * @see TopAppBar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LucyAppBar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
    containerColor: Color = LucyTheme.colors.neutral20,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            ProvideTextStyle(value = LucyTheme.typography.smallHeadline) {
                title()
            }
        },
        navigationIcon = navigationIcon,
        actions = {
            Row(
                modifier = Modifier.padding(end = 8.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                content = actions
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = containerColor),
        scrollBehavior = scrollBehavior,
    )
}
