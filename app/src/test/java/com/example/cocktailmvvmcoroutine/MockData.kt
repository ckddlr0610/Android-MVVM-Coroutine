package com.example.cocktailmvvmcoroutine

import com.example.cocktailmvvmcoroutine.data.model.Cocktail

object MockData {
    fun getMockCocktailList() =
        Cocktail(
            idDrink = 0,
            strDrink = "milkCocktail",
            strDrinkThumb = "milkTwo"
        )
}
