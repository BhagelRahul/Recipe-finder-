package com.example.recipefinder.ui.theme.viewModel


import com.example.recipefinder.data.Model.Meal

sealed class RecipeViewState {
     object Loading: RecipeViewState()
     data class Success(val recipes: List<Meal>): RecipeViewState()
     data class Error(val message: String): RecipeViewState()
}