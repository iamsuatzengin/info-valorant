package com.suatzengin.infovalorant.presentation.agents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.suatzengin.infovalorant.data.remote.agents.Agents
import com.suatzengin.infovalorant.ui.theme.background

@Composable
fun AgentsScreen(
    viewModel: AgentsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val list = state.value.agents

    Scaffold(
        backgroundColor = background,
        topBar = {
            TopAppBar(
                title = {
                    Text("Agents",style = MaterialTheme.typography.subtitle1)},
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
                elevation = 0.dp
            )
        },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(paddingValues = it)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 2)
            ) {
                items(items = list) { item ->
                    AgentListItem(item)
                }
            }
        }
    }
}


@Composable
fun AgentListItem(agent: Agents) {

    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) {
        Card(
            backgroundColor = Color(0xFFFFFBF5),
            modifier = Modifier
                .padding(8.dp)
                .size(150.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = agent.displayName,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = agent.role.displayName,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(4.dp),
                    fontSize = 10.sp
                )
            }
        }

        SubcomposeAsyncImage(
            model = agent.fullPortraitV2, contentDescription = "Icon Agent",
            modifier = Modifier
                .height(200.dp)
                .padding(12.dp),
            loading = {
                CircularProgressIndicator(
                    color = Color.DarkGray, modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            },
            alignment = Alignment.BottomEnd
        )
    }

}
