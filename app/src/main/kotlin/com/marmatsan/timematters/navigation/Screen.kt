package com.marmatsan.heal_th.navigation

sealed class Screen(val route: String) {
    data object Welcome : Screen(route = "welcome")
    data object Home : Screen(route = "home")
}