package com.example.read.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun gradient(
    start: Offset = Offset(0f, Float.POSITIVE_INFINITY),
    end: Offset = Offset(Float.POSITIVE_INFINITY, 0f),
    colors: List<Color>,
): Brush {
    return Brush.linearGradient(colors, start, end)
}