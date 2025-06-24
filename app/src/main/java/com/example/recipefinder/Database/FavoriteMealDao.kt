package com.example.recipefinder.Database
import androidx.room.*

@Dao
interface FavoriteMealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(meal: FavoriteMealEntity)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): kotlinx.coroutines.flow.Flow<List<FavoriteMealEntity>>

    @Delete
    suspend fun delete(meal: FavoriteMealEntity)
}
