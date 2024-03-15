package com.example.core.domain.preferences

interface SettingsRepository {

    fun updateLanguage(language: String)
    fun updateTheme(darkTheme: Boolean)

    fun loadLocalizationInfo(): String
    fun loadThemeInfo(): Boolean

    companion object {
        const val KEY_LANGUAGE = "Language"
        const val KEY_THEME = "Theme"
        const val DEFAULT_LANGUAGE = "En_Us"
        const val DARK_THEME_BY_DEFAULT = false
    }
}