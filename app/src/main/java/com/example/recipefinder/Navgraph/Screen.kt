package com.example.recipefinder.Navgraph

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Favourite : Screen("favourite")
}
