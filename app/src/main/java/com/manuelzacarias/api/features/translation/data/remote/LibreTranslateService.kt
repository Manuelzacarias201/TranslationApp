package com.manuelzacarias.api.features.translation.data.remote

import com.manuelzacarias.api.features.translation.data.remote.dto.TranslationResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface LibreTranslateService {
    @GET("get")
    suspend fun translate(
        @Query("q") query: String,
        @Query("langpair") langPair: String
    ): TranslationResponseDto
}
