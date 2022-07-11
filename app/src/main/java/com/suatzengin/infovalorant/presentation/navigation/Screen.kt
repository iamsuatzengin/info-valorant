package com.suatzengin.infovalorant.presentation.navigation

import com.suatzengin.infovalorant.R


sealed class Screen(val route: String, val image: Int){
    object Agents: Screen(route = "agents", image = R.drawable.agent_icon)
    object Weapons: Screen(route = "weapons", image = R.drawable.weapons_icon)
    object Maps: Screen(route = "maps", image = R.drawable.map_icon)
    object Ranks: Screen(route = "ranks", image = R.drawable.category_icon)
}
