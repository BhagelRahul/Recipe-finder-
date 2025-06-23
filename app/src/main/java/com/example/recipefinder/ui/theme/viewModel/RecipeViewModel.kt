package com.example.recipefinder.ui.theme.viewModel


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipefinder.data.Network.MealApiClient
import kotlinx.coroutines.launch
import androidx.compose.runtime.State

class RecipeViewModel: ViewModel() {
    private val _state= mutableStateOf<RecipeViewState>(RecipeViewState.Loading)
    val state: State<RecipeViewState> = _state

    fun processIntent(intent: RecipeViewIntent){
        when(intent){
            is RecipeViewIntent.LoadRandomRecipe -> loadRandomRecipe()
            is  RecipeViewIntent.SearchRecipes ->searchRecipe(intent.query)
        }
    }
    private fun loadRandomRecipe(){
        viewModelScope.launch{
            _state.value= RecipeViewState.Loading
            try{
                _state.value= RecipeViewState.Success(
                    MealApiClient.getRandomRecipe()
                )
            }catch (e: Exception){
                _state.value= RecipeViewState.Error("Error fetching recipe")
                Log.e("RecipeViewModel", "API Error", e)
            }
        }
    }

    private fun searchRecipe(query:String){
        viewModelScope.launch{
            _state.value= RecipeViewState.Loading
            try{
                _state.value= RecipeViewState.Success(
                    MealApiClient.getSearchedRecipe(query)
                )
            }catch (e: Exception){
                _state.value= RecipeViewState.Error("Recipe not found")
                Log.e("RecipeViewModel", "API Error", e)
            }
        }
    }
}