package com.manuelzacarias.api.features.translation.data.mapper

import com.manuelzacarias.api.features.translation.data.datasources.remote.model.TranslationResponse
import com.manuelzacarias.api.features.translation.domain.entities.Translation

object TranslationMapper {
    fun fromDto(dto: TranslationResponse): Translation {
        return Translation(
            translatedText = dto.responseData.translatedText
        )
    }
}
