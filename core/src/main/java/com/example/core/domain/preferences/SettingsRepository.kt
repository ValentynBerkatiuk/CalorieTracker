package com.example.core.domain.preferences

import com.example.core.domain.model.SettingsInfo

interface SettingsRepository {

    fun updateLanguage(language: String)
    fun updateTheme(theme: String)

    fun loadSettingInfo(): SettingsInfo

    companion object {
        const val KEY_LANGUAGE = "Language"
        const val KEY_THEME = "Theme"
        const val DEFAULT_LANGUAGE = "English"
        const val DEFAULT_THEME = "Light"
    }
}