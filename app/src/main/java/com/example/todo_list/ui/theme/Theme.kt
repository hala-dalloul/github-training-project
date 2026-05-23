package com.example.todo_list.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = Burgundy,
    onPrimary = Background,

    secondary = Mocha,
    onSecondary = Background,

    background = Background,
    onBackground = Burgundy,

    surface = Surface,
    onSurface = Burgundy,

    outline = Outline,

    error = Error
)

private val DarkColors = darkColorScheme(

    primary = Rose,
    onPrimary = DarkBackground,

    secondary = Mocha,
    onSecondary = Background,

    background = DarkBackground,
    onBackground = Background,

    surface = DarkSurface,
    onSurface = Background,

    outline = Outline,

    error = Error
)

@Composable
fun TaskTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}