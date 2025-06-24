package com.example.recipefinder.ui.theme.components


import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.SnapPosition.Center
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.recipefinder.Database.FavoriteMealEntity
import com.example.recipefinder.ui.theme.viewModel.MealViewModel

//@Composable
//fun FavouriteScreen() {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "hello favourite")
//
//
//    }
//
//}
@Composable
fun FavouriteScreen(viewModel: MealViewModel = viewModel()) {
    val favorites by viewModel.favoriteMeals.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 8.dp)
    ) {
        Text(text = "❤️  Your Favorite Recipes",
            fontSize = 26.sp,
            fontWeight = FontWeight(900),
            fontFamily = FontFamily.Cursive,
            color = Color(0xFF7F462C),
            modifier = Modifier.padding(8.dp)
        )
        Divider()
        Spacer(modifier = Modifier.height(10.dp))

        if (favorites.isEmpty()) {
            Text("No favorites yet! Save some recipes 🍽️", color = Color.Gray)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                items(favorites.size) { i ->
                    FavoriteMealItem(favorites[i],viewModel)
                }
            }

        }
    }

}







