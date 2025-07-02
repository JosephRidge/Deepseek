package com.jayr.deepseek.data.models

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBarItem(
    var title: String,
    var iconSelected: ImageVector? = null,
    var iconNotSelected: ImageVector? = null,
    var iconCustomSelected: Any? = null,
    var iconCustomNotSelected: Any? = null,
)