package com.example.cocktailmvvmcoroutine.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailmvvmcoroutine.data.model.Cocktail

@Dao
interface CocktailDao {
    @Insert
    suspend fun insertCocktailList(cocktails: List<Cocktail>)

    @Query("SELECT * FROM Cocktail WHERE index_drink BETWEEN :start AND :end")
    suspend fun getCocktailListPerPage(start: Int, end:Int) : List<Cocktail>

    @Query("DELETE FROM Cocktail")
    suspend fun clearTable()
}
