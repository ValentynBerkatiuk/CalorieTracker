package com.example.tracker_presentation.tracker_overview

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.core.domain.preferences.SettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository,
): ViewModel() {

    var settingsData: Boolean
        get() = loadThemeInfo()

    init {
        settingsData = loadThemeInfo()
    }

    fun updateTheme(isDarkTheme: Boolean) {
        settingsRepository.updateTheme(isDarkTheme)
    }

    private fun loadThemeInfo(): Boolean = settingsRepository.loadThemeInfo()

}