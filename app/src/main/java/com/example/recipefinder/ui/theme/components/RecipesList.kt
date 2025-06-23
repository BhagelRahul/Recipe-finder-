package com.example.recipefinder.ui.theme.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.recipefinder.data.Model.Meal


@Composable
fun RecipesList(
    recipes: List<Meal>,
    onSaveClicked: (Meal) -> Unit = {}
) {
    LazyColumn {
        items(recipes) { meal ->
            RecipeListItem(
                meal = meal,
                onSaveClicked = onSaveClicked
            )
        }
    }
}







