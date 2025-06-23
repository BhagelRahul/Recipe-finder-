package com.example.recipefinder.ui.theme.components

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.recipefinder.data.Model.Meal

@Composable
fun RecipeListItem(meal: Meal, onSaveClicked: (Meal) -> Unit) {

    var expanded by remember { mutableStateOf(false) }


    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFF0F8FF)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(5.dp)

    ) {
        Column(modifier = Modifier.padding(5.dp)) {

            if (!meal.strMealThumb.isNullOrEmpty()) {
                AsyncImage(
                    model = meal.strMealThumb,
                    contentDescription = "thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

        }
        //Spacer(modifier = Modifier.padding( 4.dp))
        Text(
            modifier = Modifier.padding(16.dp),
            text = meal.strMeal ?: "",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF7F462C),
            fontWeight = FontWeight.Bold,
        )
        Divider()
        //Spacer(modifier = Modifier.padding(4.dp))
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Ingredients :",
            textDecoration = TextDecoration.Underline,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = getIngredients(meal)
        )
        Divider()
        Spacer(modifier = Modifier.padding(5.dp))

        AnimatedVisibility(visible = expanded) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    text = "Instructions ",
                    textDecoration = TextDecoration.Underline,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Normal,
                    text = meal.strInstructions ?: ""
                )
                Divider()

                //  buttton to play youutbe video
                val context = LocalContext.current
                val url = meal.strYoutube ?: ""

                Button(
                    onClick = {
                        if (url.isNotBlank()) {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            context.startActivity(intent)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFA0CFEC),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()

                ) {
                    Text(text = "Watch Recipe Video 👁️‍🗨️")
                }

                Button(
                    onClick = {
                        onSaveClicked(meal)
                        Toast.makeText(context, "saved successfully", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFA0CFEC),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()

                ) {
                    Text(text = "Save Recipe")
                }

            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                expanded = !expanded
            }) {
            Icon(
                imageVector = if (expanded)
                    Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Clear",
                tint = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)

            )
        }
    }
}

fun getIngredients(meal: Meal): String {
    var ingredients = ""
    with(meal) {
        if (!strIngredient1.isNullOrEmpty()) ingredients += "Ingredient:1 - $strMeasure1\n"
        if (!strIngredient2.isNullOrEmpty()) ingredients += "Ingredient:2 - $strMeasure2\n"
        if (!strIngredient3.isNullOrEmpty()) ingredients += "Ingredient:3 - $strMeasure3\n"
        if (!strIngredient4.isNullOrEmpty()) ingredients += "Ingredient:4 - $strMeasure4\n"
        if (!strIngredient5.isNullOrEmpty()) ingredients += "Ingredient:5- $strMeasure5\n"
        if (!strIngredient6.isNullOrEmpty()) ingredients += "Ingredient:6 - $strMeasure6\n"
        if (!strIngredient7.isNullOrEmpty()) ingredients += "Ingredient:7 - $strMeasure7\n"
        if (!strIngredient8.isNullOrEmpty()) ingredients += "Ingredient:8 - $strMeasure8\n"
        if (!strIngredient9.isNullOrEmpty()) ingredients += "Ingredient:9 - $strMeasure9\n"
        if (!strIngredient10.isNullOrEmpty()) ingredients += "Ingredient:10 - $strMeasure10\n"
        if (!strIngredient11.isNullOrEmpty()) ingredients += "Ingredient:11 - $strMeasure11\n"
        if (!strIngredient12.isNullOrEmpty()) ingredients += "Ingredient:12 - $strMeasure12\n"
        if (!strIngredient13.isNullOrEmpty()) ingredients += "Ingredient:13 - $strMeasure13\n"
        if (!strIngredient14.isNullOrEmpty()) ingredients += "Ingredient:14 - $strMeasure14\n"
        if (!strIngredient15.isNullOrEmpty()) ingredients += "Ingredient:15 - $strMeasure15\n"
        if (!strIngredient16.isNullOrEmpty()) ingredients += "Ingredient:16 - $strMeasure16\n"
        if (!strIngredient17.isNullOrEmpty()) ingredients += "Ingredient:17 - $strMeasure17\n"
        if (!strIngredient18.isNullOrEmpty()) ingredients += "Ingredient:18 - $strMeasure18\n"
        if (!strIngredient19.isNullOrEmpty()) ingredients += "Ingredient:19 - $strMeasure19\n"
        if (!strIngredient20.isNullOrEmpty()) ingredients += "Ingredient:20 - $strMeasure20\n"


    }
    return ingredients.trimEnd('\n')
}
