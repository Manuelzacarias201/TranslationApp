package com.manuelzacarias.api.features.translation.data.datasources.remote

import com.manuelzacarias.api.features.translation.data.datasources.remote.model.TranslationResponse

interface TranslationRemoteDataSource {
    suspend fun translate(query: String, langPair: String): TranslationResponse
}
