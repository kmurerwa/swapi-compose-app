package com.murerwa.swapiapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = MaroonPrimary,
    primaryVariant = OrangePrimary,
    secondary = YellowPrimary
)

private val LightColorPalette = lightColors(
    primary = MaroonPrimary,
    primaryVariant = OrangePrimary,
    secondary = YellowPrimary
)

@Composable
fun SWAPIAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}