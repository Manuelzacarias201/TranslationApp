package com.manuelzacarias.api.features.translation.presentation.screens

data class TranslationUiState(
    val isLoading: Boolean = false,
    val translatedText: String? = null,
    val error: String? = null,
    val isTranslating: Boolean = false
)
