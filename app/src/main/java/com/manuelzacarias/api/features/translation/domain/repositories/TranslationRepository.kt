package com.manuelzacarias.api.features.translation.domain.repositories

import com.manuelzacarias.api.features.translation.domain.entities.Translation

interface TranslationRepository {
    suspend fun translate(text: String, source: String = "auto", target: String): Result<Translation>
}
