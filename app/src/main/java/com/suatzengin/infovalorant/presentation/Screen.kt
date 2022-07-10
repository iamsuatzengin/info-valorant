package com.suatzengin.infovalorant.presentation



sealed class Screen(val route: String){
    object Agents: Screen(route = "agents")
    object Weapons: Screen(route = "weapons")
}
