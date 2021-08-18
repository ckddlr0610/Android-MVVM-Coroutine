package com.example.cocktailmvvmcoroutine.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocktailmvvmcoroutine.data.model.Cocktail

@Database(entities = [Cocktail::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}
