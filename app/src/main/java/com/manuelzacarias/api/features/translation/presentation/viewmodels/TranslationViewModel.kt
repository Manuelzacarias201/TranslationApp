package com.manuelzacarias.api.features.translation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuelzacarias.api.features.translation.domain.usecases.GetTranslationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class TranslationUiState {
    object Idle : TranslationUiState()
    object Loading : TranslationUiState()
    data class Success(val result: String) : TranslationUiState()
    data class Error(val message: String) : TranslationUiState()
}

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val getTranslationUseCase: GetTranslationUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<TranslationUiState>(TranslationUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun translate(text: String, source: String, target: String) {
        viewModelScope.launch {
            _uiState.value = TranslationUiState.Loading
            getTranslationUseCase(text, source, target)
                .onSuccess { translation ->
                    _uiState.value = TranslationUiState.Success(translation.translatedText)
                }
                .onFailure { error ->
                    _uiState.value = TranslationUiState.Error(error.message ?: "Error desconocido")
                }
        }
    }
}
