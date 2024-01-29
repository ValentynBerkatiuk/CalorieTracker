package com.example.onboarding_presentation.height

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calorietracker.R
import com.example.core.domain.preferences.Preferences
import com.example.core.domain.use_case.FilterOutDigits
import com.example.core.util.UIText
import com.example.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
   private val preferences: Preferences,
   private val filterOutDigits: FilterOutDigits
): ViewModel() {

    var height by mutableStateOf(HEIGHT_BY_DEFAULT)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAgeEnter(height: String) {
        if(height.length <= MINIMUM_LENGTH){
            this.height = filterOutDigits(height)
        }
    }

    fun onNextClick() {
        viewModelScope.launch {
            val heightNumber = height.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackbar(
                       UIText.StringResource(R.string.error_height_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveHeight(heightNumber)
            _uiEvent.send(UiEvent.Success)
        }
    }

    companion object {
        private const val HEIGHT_BY_DEFAULT = "170"
        private const val MINIMUM_LENGTH = 3
    }
}