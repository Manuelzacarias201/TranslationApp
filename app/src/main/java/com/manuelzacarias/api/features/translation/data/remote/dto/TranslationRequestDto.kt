package com.manuelzacarias.api.features.translation.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TranslationRequestDto(
    @SerializedName("q") val q: String,
    @SerializedName("source") val source: String,
    @SerializedName("target") val target: String,
    @SerializedName("format") val format: String = "text"
)
