package com.example.core.data.preferences

import android.content.SharedPreferences
import com.example.core.domain.preferences.SettingsRepository

class SettingsPreferences(
    private val sharedPreferences: SharedPreferences
): SettingsRepository {

    override fun updateLanguage(language: String) {
        sharedPreferences.edit().putString(SettingsRepository.KEY_LANGUAGE, language).apply()
    }

    override fun updateTheme(darkTheme: Boolean) {
        sharedPreferences.edit().putBoolean(SettingsRepository.KEY_THEME, darkTheme).apply()
    }

    override fun loadLocalizationInfo(): String {
        return sharedPreferences.getString(SettingsRepository.KEY_LANGUAGE, SettingsRepository.DEFAULT_LANGUAGE) ?: SettingsRepository.DEFAULT_LANGUAGE
    }

    override fun loadThemeInfo(): Boolean = sharedPreferences.getBoolean(SettingsRepository.KEY_THEME, SettingsRepository.DARK_THEME_BY_DEFAULT)
}