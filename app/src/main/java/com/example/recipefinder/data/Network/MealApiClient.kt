package com.example.recipefinder.data.Network


import com.example.recipefinder.data.Model.Meal
import com.example.recipefinder.data.Model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

object MealApiClient {
    private val apiClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getRandomRecipe(): List<Meal> {
        val url = "https://www.themealdb.com/api/json/v1/1/random.php"
        val response = apiClient.get(url).body() as MealResponse
        return response.meals ?: emptyList()
    }

    suspend fun getSearchedRecipe(query: String): List<Meal> {
        val url = "https://www.themealdb.com/api/json/v1/1/search.php?s=$query"
        val response = apiClient.get(url).body() as MealResponse
        return response.meals ?: emptyList()
    }
}
