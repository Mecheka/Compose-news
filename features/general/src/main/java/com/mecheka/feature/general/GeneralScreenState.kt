@file:OptIn(ExperimentalContracts::class)

package com.mecheka.feature.general

import com.mecheka.data.model.ArticleResponse
import kotlin.contracts.ExperimentalContracts

sealed interface GeneralScreenState

object Loading : GeneralScreenState
object Error : GeneralScreenState
data class Success(val data: List<ArticleResponse>) : GeneralScreenState