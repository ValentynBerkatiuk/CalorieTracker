package com.simpleappsdev.settings_presentation.settings

data class SettingsScreenState(
    val theme: String,
    val language: String,
    val isMenuExposedLanguages: Boolean = false,
    val isMenuExposed: Boolean = false
)
