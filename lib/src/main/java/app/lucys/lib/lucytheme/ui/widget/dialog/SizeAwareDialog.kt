package app.lucys.lib.lucytheme.ui.widget.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import app.lucys.lib.lucytheme.ui.theme.LucyTheme
import app.lucys.lib.lucytheme.ui.util.SizeCategory
import app.lucys.lib.lucytheme.ui.widget.appbar.LucyAppBar

/**
 * A "Size-Aware" component that will render a dialog with a different layout depending on the
 * [sizeCategory] provided.
 * @param onDismiss The callback to be invoked when the dialog is dismissed.
 * @param title The title to be displayed in the dialog.
 * @param titleLeading The leading content to be displayed in the title.
 * @param actions The actions to be displayed in the dialog.
 * @param scrollBehavior The scroll behavior to be applied to the dialog.
 * @param sizeCategory The [SizeCategory] to be used to determine the layout of the dialog.
 * @param content The content to be displayed in the dialog.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SizeAwareDialog(
    onDismiss: () -> Unit,
    title: @Composable () -> Unit,
    titleLeading: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
    sizeCategory: SizeCategory,
    content: @Composable ColumnScope.() -> Unit,
) {
    val isCompact by rememberUpdatedState(sizeCategory.isMobile())

    val sizeModifier by rememberUpdatedState(
        when (isCompact) {
            true -> Modifier.fillMaxSize()
            false -> Modifier.padding(vertical = 32.dp)
        }
    )

    val dialogShape by rememberUpdatedState(
        when (isCompact) {
            true -> RectangleShape
            false -> AlertDialogDefaults.shape
        }
    )
    val appBarContainerColor by rememberUpdatedState(
        when (isCompact) {
            true -> LucyTheme.colors.neutral20
            false -> LucyTheme.colors.neutral10
        }
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = !isCompact,
            dismissOnClickOutside = false,
            dismissOnBackPress = false,
            decorFitsSystemWindows = !isCompact,
        ),
    ) {
        Column(
            modifier = sizeModifier
                .clip(dialogShape)
                .background(LucyTheme.colors.neutral10)
                .consumeWindowInsets(WindowInsets.ime)
                .padding(bottom = 16.dp)
                .navigationBarsPadding(),
        ) {
            LucyAppBar(
                title = title,
                navigationIcon = titleLeading,
                actions = actions,
                scrollBehavior = scrollBehavior,
                containerColor = appBarContainerColor,
            )
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(widthDp = 720, heightDp = 600, showBackground = true)
fun SizeAwareDialogTabletPreview() {
    LucyTheme {
        SizeAwareDialog(
            onDismiss = { },
            title = { Text(text = "A title") },
            sizeCategory = SizeCategory.Tablet,
            titleLeading = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
        ) {
            Text(text = "This is a text")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(widthDp = 420, heightDp = 720, showBackground = true)
fun SizeAwareDialogMobilePreview() {
    LucyTheme {
        SizeAwareDialog(
            onDismiss = { },
            title = { Text(text = "A title") },
            sizeCategory = SizeCategory.MobilePortrait,
            titleLeading = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "Content", modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
