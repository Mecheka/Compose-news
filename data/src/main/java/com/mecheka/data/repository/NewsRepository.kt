package com.mecheka.data.repository

import com.mecheka.data.api.NewsApi
import com.mecheka.data.model.ArticleResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface NewsRepository {
    fun getTopHeadlinesByCategory(category: String): Flow<List<ArticleResponse>>
}

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi): NewsRepository {
    override fun getTopHeadlinesByCategory(category: String): Flow<List<ArticleResponse>> {
        TODO("Not yet implemented")
    }
}