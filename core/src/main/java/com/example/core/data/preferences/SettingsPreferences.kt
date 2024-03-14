package com.example.core.data.preferences

import android.content.SharedPreferences
import com.example.core.domain.model.SettingsInfo
import com.example.core.domain.preferences.SettingsRepository

class SettingsPreferences(
    private val sharedPreferences: SharedPreferences
): SettingsRepository {

    override fun updateLanguage(language: String) {
        sharedPreferences.edit().putString(SettingsRepository.KEY_LANGUAGE, language).apply()
    }

    override fun updateTheme(theme: String) {
        sharedPreferences.edit().putString(SettingsRepository.KEY_THEME, theme).apply()
    }

    override fun loadSettingInfo(): SettingsInfo {
        val language = sharedPreferences.getString(SettingsRepository.KEY_LANGUAGE, SettingsRepository.DEFAULT_LANGUAGE)
        val theme = sharedPreferences.getString(SettingsRepository.KEY_THEME, SettingsRepository.DEFAULT_THEME)
        return SettingsInfo(
            language ?: SettingsRepository.DEFAULT_LANGUAGE,
            theme ?: SettingsRepository.DEFAULT_THEME
        )

    }
}