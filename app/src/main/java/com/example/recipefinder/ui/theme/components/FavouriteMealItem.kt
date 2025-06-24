package com.example.recipefinder.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.util.TableInfo
import coil.compose.AsyncImage
import com.example.recipefinder.Database.FavoriteMealEntity
import com.example.recipefinder.ui.theme.viewModel.MealViewModel


@Composable
fun FavoriteMealItem(meal: FavoriteMealEntity,viewModel: MealViewModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = meal.strMealThumb,
            contentDescription = "Meal Image",
            modifier = Modifier.size(60.dp)
            .clip(RoundedCornerShape(6.dp)),
            contentScale = ContentScale.Fit

        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = meal.strMeal ?: "Unnamed",
            modifier = Modifier.alignByBaseline(),
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.Default.Delete, contentDescription = "delete button",
            modifier = Modifier.clickable{
               viewModel.deleteFavoriteMeal(meal)
        })
    }
}