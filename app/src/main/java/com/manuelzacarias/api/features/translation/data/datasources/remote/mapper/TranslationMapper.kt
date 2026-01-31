package com.manuelzacarias.api.features.translation.data.datasources.remote.mapper

import com.manuelzacarias.api.features.translation.data.datasources.remote.model.TranslationResponse
import com.manuelzacarias.api.features.translation.domain.entities.Translation

fun TranslationResponse.toDomain(): Translation {
    return Translation(
        translatedText = this.responseData.translatedText
    )
}
