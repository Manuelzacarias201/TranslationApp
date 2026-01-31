package com.manuelzacarias.api.core.network

import com.manuelzacarias.api.features.translation.data.datasources.remote.model.TranslationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslationApi {
    @GET("get")
    suspend fun translate(
        @Query("q") query: String,
        @Query("langpair") langPair: String
    ): TranslationResponse
}
