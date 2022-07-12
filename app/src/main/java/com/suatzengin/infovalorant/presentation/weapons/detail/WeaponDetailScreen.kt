package com.suatzengin.infovalorant.presentation.weapons.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.suatzengin.infovalorant.data.remote.weapons.Weapons
import com.suatzengin.infovalorant.ui.theme.background

@Composable
fun WeaponDetailScreen(
    viewModel: WeaponDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {

        },
        backgroundColor = background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(paddingValues = it)
        ) {
            state.weapon?.let { weapon ->

                DisplayWeapon(weapon = weapon)
            }
        }
    }
}

@Composable
fun DisplayWeapon(weapon: Weapons) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color.DarkGray, shape = RoundedCornerShape(12.dp))
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = weapon.displayIcon,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
            )

        Text(text = weapon.displayName, fontSize = 32.sp, color = Color.White)

    }
}
