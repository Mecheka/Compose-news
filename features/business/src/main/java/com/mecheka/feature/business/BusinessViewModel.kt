package com.mecheka.feature.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mecheka.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _viewState = MutableStateFlow<BusinessScreenState>(Loading)
    val viewState = _viewState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getTopHeadlinesByCategory("business")
                .catch {
                    _viewState.value = Error
                }.flowOn(Dispatchers.IO)
                .collect {
                    _viewState.value = Success(it)
                }
        }
    }
}