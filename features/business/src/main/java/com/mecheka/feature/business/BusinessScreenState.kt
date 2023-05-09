@file:OptIn(ExperimentalContracts::class)

package com.mecheka.feature.business

import com.mecheka.data.model.ArticleResponse
import kotlin.contracts.ExperimentalContracts

sealed interface BusinessScreenState

object Loading : BusinessScreenState
object Error : BusinessScreenState
data class Success(val data: List<ArticleResponse>) : BusinessScreenState