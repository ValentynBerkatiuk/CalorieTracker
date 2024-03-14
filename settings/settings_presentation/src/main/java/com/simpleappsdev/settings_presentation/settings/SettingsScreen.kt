package com.simpleappsdev.settings_presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.simpleappsdev.settings_presentation.DarkColorPalette
import com.simpleappsdev.settings_presentation.LightColorPalette
import com.simpleappsdev.settings_presentation.components.LanguageDropdownMenu
import com.simpleappsdev.settings_presentation.components.ThemeSwitcher
import java.util.Locale

@Composable
fun SettingsScreen(
    darkTheme: Boolean, onThemeUpdated: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column {
        Text(text = "Выберите язык:")
        LanguageDropdownMenu(
            items = languages.keys.toList(),
            onItemSelected = { chosenLanguage ->
                languages[chosenLanguage]?.language?.let { language ->
                    viewModel.updateLanguage(language)
                }
            }
        )

        Text(text = "Выберите тему:")
        ThemeSwitcher(
            darkTheme = darkTheme,
            size = 50.dp,
            padding = 5.dp,
            onClick = onThemeUpdated
        )
    }
}
val languages = mapOf(
    "English" to Locale.ENGLISH,
    "Українська" to Locale.forLanguageTag("uk"),
)

val themes = mapOf(
    "Dark" to DarkColorPalette,
    "Light" to LightColorPalette,
)