package app.lucys.lib.lucytheme.ui.util

import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass

sealed interface SizeCategory {
    data object MobilePortrait : SizeCategory
    data object MobileLandscape : SizeCategory
    data object Tablet : SizeCategory
    data object Expanded : SizeCategory

    fun isMobile(): Boolean {
        return this == MobilePortrait || this == MobileLandscape
    }

    companion object {
        fun calculate(size: WindowSizeClass): SizeCategory {
            val widthClass = size.windowWidthSizeClass
            val heightClass = size.windowHeightSizeClass

            if (
                widthClass == WindowWidthSizeClass.COMPACT &&
                heightClass != WindowHeightSizeClass.COMPACT
            ) {
                return MobilePortrait
            }

            if (heightClass == WindowHeightSizeClass.COMPACT) {
                return MobileLandscape
            }

            return when (widthClass) {
                WindowWidthSizeClass.MEDIUM -> Tablet
                else -> Expanded
            }
        }
    }
}

@Composable
fun currentSizeCategory() = currentWindowAdaptiveInfo().sizeCategory()

fun WindowAdaptiveInfo.sizeCategory(): SizeCategory {
    return SizeCategory.calculate(this.windowSizeClass)
}