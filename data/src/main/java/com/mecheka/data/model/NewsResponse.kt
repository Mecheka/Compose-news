package com.mecheka.data.model


import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    val articleResponses: List<ArticleResponse>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
)