package com.suatzengin.infovalorant.presentation.agents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.suatzengin.infovalorant.data.remote.agents.Agents
import com.suatzengin.infovalorant.ui.theme.background

@Composable
fun AgentsScreen(
    viewModel: AgentsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val list = state.value.agents

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = background
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(items = list) { item ->
                AgentListItem(item)
            }
        }
    }

}

@Composable
fun AgentListItem(agent: Agents) {
    val visible = remember { mutableStateOf(false) }
    Card(
        backgroundColor = Color(0xFFFFFBF5),
        modifier = Modifier
            .padding(8.dp)
            .clickable { visible.value = !visible.value }
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                model = agent.displayIcon, contentDescription = "Icon Agent",
                modifier = Modifier
                    .size(120.dp)
                    .padding(4.dp),
                loading = {
                    CircularProgressIndicator(color = Color.DarkGray)
                }
            )
            AnimatedVisibility(visible = visible.value) {
                Text(
                    text = agent.displayName,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}
