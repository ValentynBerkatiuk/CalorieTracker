package com.example.core.domain.preferences

interface SettingsRepository {

    fun updateLanguage(language: String)
    fun updateTheme(darkTheme: Boolean)

    fun loadThemeInfo(): Boolean

    companion object {
        const val KEY_LANGUAGE = "Language"
        const val KEY_THEME = "Theme"
        const val DARK_THEME_BY_DEFAULT = false
    }
}