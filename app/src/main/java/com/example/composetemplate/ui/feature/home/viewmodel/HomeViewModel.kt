package com.example.composetemplate.ui.feature.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.composetemplate.data.repository.home.HomeRepository
import com.example.composetemplate.ui.base.BaseUiEvent
import com.example.composetemplate.ui.base.BaseUiState
import com.example.composetemplate.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : BaseViewModel<HomeScreenState, HomeScreenEvent>(HomeScreenState()) {

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.LoadData -> loadItems()
            is HomeScreenEvent.NavigateDetail -> sendEvent(event)
            is HomeScreenEvent.ShowMessage -> sendEvent(event)
            else -> {}
        }
    }

    private fun loadItems() {
        viewModelScope.launch {
            updateState { it.copy(isLoading = true, error = null) }
        }
    }
}

data class HomeScreenState(
    val isLoading: Boolean = false,
    val items: List<String> = emptyList(),
    val error: String? = null
) : BaseUiState

sealed class HomeScreenEvent : BaseUiEvent {
    data object BackPressed : HomeScreenEvent()
    data object LoadData : HomeScreenEvent()
    data class NavigateDetail(val id: String) : HomeScreenEvent()
    data class ShowMessage(val message: String) : HomeScreenEvent()
}


