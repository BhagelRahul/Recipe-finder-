package com.example.recipefinder.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipefinder.R
import kotlinx.coroutines.delay


@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(3000)
        onTimeout()
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 50.dp)) {
            Text(
                text = "   Find Your Recipe Here ?",
                fontSize = 26.sp,
                fontWeight = FontWeight(900),
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 10.dp)) {
            Text(
                text = "    Are You Foody, Yes ?",
                fontSize = 23.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(8.dp)
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp)) {
            Text(
                text = "  \uD83D\uDC49 This is Only for U  ",
                fontSize = 20.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily.Serif,
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .size(600.dp)
                .fillMaxSize(),

            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.mipmap.foods),
                contentDescription = "App Icon",
                modifier = Modifier.size(389.dp),
                contentScale = Crop
            )
        }
    }
}
