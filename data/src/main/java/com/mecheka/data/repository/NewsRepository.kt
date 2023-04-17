package com.mecheka.data.repository

import com.mecheka.data.api.NewsApi
import com.mecheka.data.model.ArticleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface NewsRepository {
    fun getTopHeadlinesByCategory(category: String): Flow<List<ArticleResponse>>
}

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi) : NewsRepository {
    override fun getTopHeadlinesByCategory(category: String): Flow<List<ArticleResponse>> {
        return flow {
            val response = api.getTopHeadLines(category = category)
            if (response.isSuccessful) {
                response.body()?.articleResponses?.let {
                    emit(it)
                }
            } else {
                error("Response is failure")
            }
        }
    }
}