package com.manuelzacarias.api.features.translation.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manuelzacarias.api.features.translation.domain.usecase.TranslateTextUseCase
import com.manuelzacarias.api.features.translation.presentation.screens.TranslationUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val translateUseCase: TranslateTextUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TranslationUiState())
    val uiState: StateFlow<TranslationUiState> = _uiState.asStateFlow()

    fun translate(text: String, source: String, target: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isTranslating = true, isLoading = true, error = null) }
            
            translateUseCase(text, source, target)
                .onSuccess { translation ->
                    _uiState.update { 
                        it.copy(
                            isTranslating = false, 
                            isLoading = false,
                            translatedText = translation.translatedText 
                        ) 
                    }
                }
                .onFailure { error ->
                    _uiState.update { 
                        it.copy(
                            isTranslating = false, 
                            isLoading = false,
                            error = error.message ?: "Error" 
                        ) 
                    }
                }
        }
    }
}
