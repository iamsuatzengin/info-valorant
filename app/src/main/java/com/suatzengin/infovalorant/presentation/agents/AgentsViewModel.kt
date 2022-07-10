package com.suatzengin.infovalorant.presentation.agents

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suatzengin.infovalorant.data.repository.ValorantRepository
import com.suatzengin.infovalorant.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val repository: ValorantRepository
) : ViewModel() {

    private val _state = mutableStateOf(AgentsState())
    val state: State<AgentsState>
        get() = _state

    init {
        getAllAgens()
    }

    private fun getAllAgens() {
        viewModelScope.launch {
            repository.getAllAgents().collect { result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = _state.value.copy(agents = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(error = result.message ?: "Error")
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true)
                    }
                }
            }
        }
    }
}