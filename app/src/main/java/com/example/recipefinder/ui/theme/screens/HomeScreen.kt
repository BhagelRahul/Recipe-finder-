package com.example.recipefinder.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.recipefinder.ui.theme.components.ErrorComponent
import com.example.recipefinder.ui.theme.components.LoadingComponent
import com.example.recipefinder.ui.theme.components.SuccessComponent
import com.example.recipefinder.ui.theme.viewModel.RecipeViewIntent
import com.example.recipefinder.ui.theme.viewModel.RecipeViewModel
import com.example.recipefinder.ui.theme.viewModel.RecipeViewState


@Composable
fun HomeScreen(recipeViewModel: RecipeViewModel, navController: NavController) {
    val state by recipeViewModel.state

    when (state) {

        is RecipeViewState.Loading -> LoadingComponent()

        is RecipeViewState.Success -> {
            val recipes = (state as RecipeViewState.Success).recipes
            SuccessComponent(
                recipe = recipes,
                navController = navController,

                onSearchClicked = { query ->
                    recipeViewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
                }
            )


        }

        is RecipeViewState.Error -> {
            val message = (state as RecipeViewState.Error).message
            ErrorComponent(message = message, onRefresgClicked = {
                recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)

            })

        }
    }
    LaunchedEffect(Unit) {
        recipeViewModel.processIntent(RecipeViewIntent.LoadRandomRecipe)
    }


}

