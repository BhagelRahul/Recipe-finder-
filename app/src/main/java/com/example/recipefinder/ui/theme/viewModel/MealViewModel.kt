package com.example.recipefinder.ui.theme.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.recipefinder.Database.AppDatabase
import com.example.recipefinder.Database.FavoriteMealEntity
import com.example.recipefinder.data.Model.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MealViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "app_database"
    ).fallbackToDestructiveMigration().build()

    private val favoriteMealDao = db.favoriteMealDao()

    val favoriteMeals = favoriteMealDao.getAllFavorites()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun saveToFavorites(meal: Meal) {
        viewModelScope.launch(Dispatchers.IO) {
            val favorite = FavoriteMealEntity(
                idMeal = meal.idMeal ?: "",
                strMeal = meal.strMeal,
                strMealThumb = meal.strMealThumb
            )
            favoriteMealDao.insert(favorite)
        }
    }

    fun deleteFavoriteMeal(meal: FavoriteMealEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteMealDao.delete(meal)
        }
    }
}
