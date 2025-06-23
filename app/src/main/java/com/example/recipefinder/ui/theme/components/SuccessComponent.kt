package com.example.recipefinder.ui.theme.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recipefinder.Navgraph.Screen
import com.example.recipefinder.data.Model.Meal


@Composable
fun SuccessComponent(
    recipe: List<Meal>,
    onSearchClicked: (query: String) -> Unit,
    navController: NavController,

    ) {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 20.dp, bottom = 35.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Search Your Desire Recipe",
                fontSize = 26.sp,
                fontWeight = FontWeight(900),
                fontFamily = FontFamily.Cursive,
                color = Color(0xFF7F462C),
                modifier = Modifier.padding(8.dp)
            )
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Add to Favorites",
                tint = Color.Red,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.navigate(Screen.Favourite.route)

                        Toast
                            .makeText(context, " Your Favourites", Toast.LENGTH_SHORT)
                            .show()
                    }
            )
        }

        SearchComponent(onSearchClicked = onSearchClicked)
        RecipesList(recipes = recipe)
    }
}


