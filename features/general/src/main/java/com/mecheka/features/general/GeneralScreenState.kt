package com.mecheka.features.general

import com.mecheka.data.model.ArticleResponse

sealed class GeneralScreenState

object Loading: GeneralScreenState()
object Error: GeneralScreenState()
data class Success(val data: List<ArticleResponse>): GeneralScreenState()
