package com.simpleappsdev.settings_presentation.settings

import androidx.compose.material.Colors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.di.CoroutineDispatchers
import com.example.core.domain.model.SettingsInfo
import com.example.core.domain.preferences.SettingsRepository
import com.example.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val dispatcher: CoroutineDispatchers
): ViewModel() {

    private var settingsData: SettingsInfo

    init {
        settingsData = loadSettingsInfo()
    }

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var state by mutableStateOf(
        SettingsScreenState(
            theme = settingsData.theme,
            language = settingsData.language
        )
    )
        private set


    fun updateLanguage(language: String) {
        viewModelScope.launch(dispatcher.io) {
            settingsRepository.updateLanguage(language)
        }
    }

    fun updateTheme(theme: Colors) {
//        viewModelScope.launch(dispatcher.io) {
//            settingsRepository.updateTheme(theme)
//        }
    }

    private fun loadSettingsInfo(): SettingsInfo {
        return settingsRepository.loadSettingInfo()
    }
}