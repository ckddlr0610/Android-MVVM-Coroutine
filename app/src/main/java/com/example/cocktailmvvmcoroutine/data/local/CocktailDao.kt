package com.example.cocktailmvvmcoroutine.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailmvvmcoroutine.data.model.Cocktail

@Dao
interface CocktailDao {
    @Insert
    suspend fun insertCocktails(cocktails: List<Cocktail>)

    @Query("SELECT * FROM Cocktail")
    suspend fun getCocktails() : List<Cocktail>

    @Query("DELETE FROM Cocktail")
    suspend fun clearTable()
}
