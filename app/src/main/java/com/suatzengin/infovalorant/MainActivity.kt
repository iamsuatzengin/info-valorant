package com.suatzengin.infovalorant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.suatzengin.infovalorant.presentation.navigation.Screen
import com.suatzengin.infovalorant.presentation.agents.AgentsScreen
import com.suatzengin.infovalorant.presentation.maps.MapsScreen
import com.suatzengin.infovalorant.presentation.navigation.BottomBar
import com.suatzengin.infovalorant.presentation.navigation.NavigateScreens
import com.suatzengin.infovalorant.presentation.ranks.RanksScreen
import com.suatzengin.infovalorant.presentation.weapons.WeaponsScreen
import com.suatzengin.infovalorant.ui.theme.InfoValorantTheme
import com.suatzengin.infovalorant.ui.theme.background
import com.suatzengin.infovalorant.ui.theme.bottomBackground
import com.suatzengin.infovalorant.ui.theme.selectedBottomItemColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfoValorantTheme {
                MainScreen()
            }
        }

    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        Screen.Agents,
        Screen.Weapons,
        Screen.Maps,
        Screen.Ranks
    )
    val visible = remember {
        mutableStateOf(true)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = background,

        bottomBar = {
            BottomBar(screens = items, navController = navController, visible = visible.value)
        }
    ) {
        NavigateScreens(navController, it)
    }
}
