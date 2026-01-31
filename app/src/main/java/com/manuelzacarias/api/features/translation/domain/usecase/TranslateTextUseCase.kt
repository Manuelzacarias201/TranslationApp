package com.manuelzacarias.api.features.translation.domain.usecase

import com.manuelzacarias.api.features.translation.domain.entities.Translation
import com.manuelzacarias.api.features.translation.domain.repositories.TranslationRepository
import javax.inject.Inject

class TranslateTextUseCase @Inject constructor(
    private val repository: TranslationRepository
) {
    suspend operator fun invoke(text: String, source: String = "auto", target: String): Result<Translation> {
        return repository.translate(text, source, target)
    }
}
