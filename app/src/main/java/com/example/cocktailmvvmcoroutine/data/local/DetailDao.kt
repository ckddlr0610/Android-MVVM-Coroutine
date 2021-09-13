package com.example.cocktailmvvmcoroutine.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cocktailmvvmcoroutine.data.model.CocktailDetailInfo
import com.example.cocktailmvvmcoroutine.data.model.Ingredient

@Dao
interface DetailDao {
    @Insert
    fun insertCocktailDetailInfo(cocktailDetailInfo: CocktailDetailInfo)

    @Query("SELECT * FROM CocktailDetailInfo WHERE idDrink = :idDrink")
    fun getCocktailDetailInfo(idDrink: Long): CocktailDetailInfo?

    @Insert
    fun insertIngredient(ingredient: Ingredient)

    @Query("SELECT * FROM Ingredient WHERE strIngredient = :strIngredient")
    fun getIngredient(strIngredient: String): Ingredient?
}
