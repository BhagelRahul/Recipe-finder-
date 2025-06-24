package com.example.recipefinder.Database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteMealEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteMealDao(): FavoriteMealDao
}
