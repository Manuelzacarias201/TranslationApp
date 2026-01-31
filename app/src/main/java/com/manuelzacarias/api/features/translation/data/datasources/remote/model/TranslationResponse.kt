package com.manuelzacarias.api.features.translation.data.datasources.remote.model

import com.google.gson.annotations.SerializedName

data class TranslationResponse(
    @SerializedName("responseData")
    val responseData: ResponseData
)

data class ResponseData(
    @SerializedName("translatedText")
    val translatedText: String
)
