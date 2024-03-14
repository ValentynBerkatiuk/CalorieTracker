package com.simpleappsdev.settings_presentation

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.example.core_ui.BrightBlue
import com.example.core_ui.DarkGray
import com.example.core_ui.LightGray
import com.example.core_ui.MediumGray
import com.example.core_ui.Orange
import com.example.core_ui.TextWhite

val DarkColorPalette = darkColorScheme(
    primary = BrightBlue,
    secondary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

val LightColorPalette = lightColorScheme(
    primary = BrightBlue,
    secondary = Orange,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)