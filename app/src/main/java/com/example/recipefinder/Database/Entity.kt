package com.example.recipefinder.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteMealEntity(
    @PrimaryKey val idMeal: String,
    val strMeal: String?,
    val strMealThumb: String?
)
