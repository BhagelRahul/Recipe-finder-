package com.example.recipefinder.ui.theme.viewModel

sealed class RecipeViewIntent {

    object LoadRandomRecipe : RecipeViewIntent()
    data class SearchRecipes(val query: String) : RecipeViewIntent()}
