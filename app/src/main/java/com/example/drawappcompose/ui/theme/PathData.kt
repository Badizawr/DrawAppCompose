package com.example.drawappcompose.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

data class PathData(
    val path: Path = Path(),
    val color: Color = Color.Black
) {
    companion object
}