package com.example.recipefinder.Navgraph

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recipefinder.data.Model.Meal
import com.example.recipefinder.ui.theme.components.FavouriteScreen
import com.example.recipefinder.ui.theme.screens.HomeScreen
import com.example.recipefinder.ui.theme.screens.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            }
        }
        composable(Screen.Home.route) {
            HomeScreen(viewModel(), navController) // Pass ViewModel if needed
        }


        composable(Screen.Favourite.route) {
            FavouriteScreen()
        }
    }
}
