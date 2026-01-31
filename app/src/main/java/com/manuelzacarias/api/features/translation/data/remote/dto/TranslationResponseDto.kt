package com.manuelzacarias.api.features.translation.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TranslationResponseDto(
    @SerializedName("responseData") val responseData: ResponseDataDto
)

data class ResponseDataDto(
    @SerializedName("translatedText") val translatedText: String
)
