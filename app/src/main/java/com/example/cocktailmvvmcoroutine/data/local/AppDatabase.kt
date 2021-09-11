package com.example.cocktailmvvmcoroutine.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.CocktailDetailInfo
import com.example.cocktailmvvmcoroutine.data.model.Ingredient

@Database(entities = [Cocktail::class, CocktailDetailInfo::class, Ingredient::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
    abstract fun detailDao(): DetailDao
}
