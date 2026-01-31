package com.manuelzacarias.api.features.translation.data.repositories

import com.manuelzacarias.api.core.network.TranslationApi
import com.manuelzacarias.api.features.translation.data.datasources.remote.mapper.toDomain
import com.manuelzacarias.api.features.translation.domain.entities.Translation
import com.manuelzacarias.api.features.translation.domain.repositories.TranslationRepository
import javax.inject.Inject

class TranslationRepositoryImpl @Inject constructor(
    private val api: TranslationApi
) : TranslationRepository {
    
    override suspend fun translate(
        text: String,
        source: String,
        target: String
    ): Result<Translation> {
        return try {
            val langPair = "$source|$target"
            val response = api.translate(text, langPair)
            
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    Result.success(body.toDomain())
                } else {
                    Result.failure(Exception("Respuesta vacía"))
                }
            } else {
                Result.failure(Exception("Error de API: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
