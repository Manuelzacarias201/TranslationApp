package com.manuelzacarias.api.core.network

import com.manuelzacarias.api.features.translation.data.datasources.remote.model.TranslationResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslationApi {
    @GET("get")
    suspend fun translate(
        @Query("q") query: String,
        @Query("langpair") langPair: String
    ): Response<TranslationResponse>
}
