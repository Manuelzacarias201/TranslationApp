package com.manuelzacarias.api.features.translation.data.datasources.remote

import com.manuelzacarias.api.core.network.TranslationApi
import com.manuelzacarias.api.features.translation.data.datasources.remote.model.TranslationResponse
import javax.inject.Inject

class TranslationRemoteDataSourceImpl @Inject constructor(
    private val api: TranslationApi
) : TranslationRemoteDataSource {
    override suspend fun translate(query: String, langPair: String): TranslationResponse {
        return api.translate(query, langPair)
    }
}
