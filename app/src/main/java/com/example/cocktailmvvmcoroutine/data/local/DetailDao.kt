package com.example.cocktailmvvmcoroutine.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailmvvmcoroutine.data.model.CocktailDetail
import com.example.cocktailmvvmcoroutine.data.model.Ingredient

@Dao
interface DetailDao {
    @Insert
    fun insertCocktailDetailInfo(cocktailDetail: CocktailDetail)

    @Query("SELECT * FROM CocktailDetail WHERE idDrink = :idDrink")
    fun getCocktailDetailInfo(idDrink: Long): CocktailDetail?

    @Insert
    fun insertIngredient(ingredient: Ingredient)

    @Query("SELECT * FROM Ingredient WHERE strIngredient = :strIngredient")
    fun getIngredient(strIngredient: String): Ingredient?
}
