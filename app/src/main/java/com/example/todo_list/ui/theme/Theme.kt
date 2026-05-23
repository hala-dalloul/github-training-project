package com.task.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.todo_list.ui.theme.AppTypography
import com.example.todo_list.ui.theme.Background
import com.example.todo_list.ui.theme.Burgundy
import com.example.todo_list.ui.theme.DarkBackground
import com.example.todo_list.ui.theme.DarkSurface
import com.example.todo_list.ui.theme.Error
import com.example.todo_list.ui.theme.Mocha
import com.example.todo_list.ui.theme.Outline
import com.example.todo_list.ui.theme.Rose
import com.example.todo_list.ui.theme.Surface

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