package com.example.recipefinder.ui.theme.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.recipefinder.data.Model.Meal
import com.example.recipefinder.ui.theme.viewModel.MealViewModel


//@Composable
//fun RecipesList(
//    recipes: List<Meal>,
//    viewModel: MealViewModel = viewModel(), meals: List<Meal>,
//    onSaveClicked: (Meal) -> Unit = {}
//) {
//    LazyColumn {
//        items(recipes) { meal ->
//            RecipeListItem(
//                meal = meal,
//                onSaveClicked = onSaveClicked
//            )
//
//            }
//        }
//    }

@Composable
fun RecipesList(viewModel: MealViewModel = viewModel(), meals: List<Meal>) {
    LazyColumn {
        items(meals) { meal ->
            RecipeListItem(meal = meal, onSaveClicked = {
                viewModel.saveToFavorites(it)
            })
        }
    }
}










