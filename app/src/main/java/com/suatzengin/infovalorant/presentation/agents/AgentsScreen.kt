package com.suatzengin.infovalorant.presentation.agents

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AgentsScreen(
    viewModel: AgentsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val list = state.value.agents

    LazyColumn {
        items(list) { item ->
            Text(text = "item: ${item.displayName}")
        }
    }

}