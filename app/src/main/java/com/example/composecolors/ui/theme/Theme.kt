package com.example.composecolors.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF54D9F8),
    onPrimary = Color(0xFF0000FF),
    primaryContainer = Color(0xFFAEAE00), //FAB
    onPrimaryContainer = Color(0xFFFFFF00), //FAB

    secondary = Color(0xFFFF0000), //not used?
    onSecondary = Color(0xFFFF0000), //not used?
    secondaryContainer = Color(0xFFFFE4B5),
    onSecondaryContainer = Color(0xFFFFA500),

    tertiary = Color(0xFFFF0000), //not used?
    onTertiary = Color(0xFFFF0000), //not used?
    tertiaryContainer = Color(0xFFFF0000), //not used?
    onTertiaryContainer = Color(0xFFFF0000), //not used?

    error = Color(0xFFFF0000),
    onError = Color(0xFFFF0000),
    errorContainer = Color(0xFFFF0000),
    onErrorContainer = Color(0xFFFF0000),

    surface = Color(0xFF8FBC8F),
    onSurface = Color(0xFF006400),
    surfaceVariant = Color(0xFFFF9796),
    onSurfaceVariant = Color(0xFFEE0000),

    background = Color(0xFFEAEAEA),
    onBackground = Color(0xFF000000),
    outline = Color(0xFFB598D0),
)

/* Default colors to override
    primary = Color.White,
    onPrimary = Color.White,
    primaryContainer = Color.White,
    onPrimaryContainer = Color.White,
    //
    secondary = Color.White,
    onSecondary = Color.White,
    secondaryContainer = Color.White,
    onSecondaryContainer = Color.White,
    //
    tertiary = Color.White,
    onTertiary = Color.White,
    tertiaryContainer = Color.White,
    onTertiaryContainer = Color.White,
    //
    error = Color.White,
    onError = Color.White,
    errorContainer = Color.White,
    onErrorContainer = Color.White,
    //
    surface = Color.White,
    onSurface = Color.White,
    surfaceVariant = Color.White,
    onSurfaceVariant = Color.White,
    //
    background = Color.White,
    onBackground = Color.White,
    outline = Color.White,
*/

@Composable
fun ComposeColorsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}