package app.lucys.lib.lucytheme.ui.util

import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

sealed interface SizeCategory {
    object MobilePortrait : SizeCategory
    object MobileLandscape : SizeCategory
    object Tablet : SizeCategory
    object Expanded : SizeCategory

    fun isMobile(): Boolean {
        return this == MobilePortrait || this == MobileLandscape
    }

    companion object {
        fun calculate(size: WindowSizeClass): SizeCategory {
            val widthClass = size.widthSizeClass
            val heightClass = size.heightSizeClass

            if (
                widthClass == WindowWidthSizeClass.Compact &&
                heightClass != WindowHeightSizeClass.Compact
            ) {
                return MobilePortrait
            }

            if (heightClass == WindowHeightSizeClass.Compact) {
                return MobileLandscape
            }

            return when (widthClass) {
                WindowWidthSizeClass.Medium -> Tablet
                else -> Expanded
            }
        }
    }
}