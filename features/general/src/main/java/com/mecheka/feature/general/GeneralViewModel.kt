package com.mecheka.feature.general

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
class GeneralViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _viewState = MutableStateFlow<GeneralScreenState>(Loading)
    val viewState = _viewState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            repository.getTopHeadlinesByCategory("general")
                .catch {
                    _viewState.value = Error
                }.flowOn(Dispatchers.IO)
                .collect {
                    _viewState.value = Success(it)
                }
        }
    }
}