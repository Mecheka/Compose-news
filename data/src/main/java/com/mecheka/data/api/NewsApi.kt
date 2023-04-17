package com.mecheka.data.api

import com.mecheka.data.BuildConfig
import com.mecheka.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int = 20,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
    ): Response<NewsResponse>
}