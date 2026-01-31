package com.manuelzacarias.api.features.translation.data.repository

import com.manuelzacarias.api.features.translation.data.datasources.remote.TranslationRemoteDataSource
import com.manuelzacarias.api.features.translation.data.mapper.TranslationMapper
import com.manuelzacarias.api.features.translation.domain.entities.Translation
import com.manuelzacarias.api.features.translation.domain.repositories.TranslationRepository
import javax.inject.Inject

class TranslationRepositoryImpl @Inject constructor(
    private val remoteDataSource: TranslationRemoteDataSource
) : TranslationRepository {
    override suspend fun translate(text: String, source: String, target: String): Result<Translation> {
        return try {
            val langPair = "$source|$target"
            val response = remoteDataSource.translate(query = text, langPair = langPair)
            Result.success(TranslationMapper.fromDto(response))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
