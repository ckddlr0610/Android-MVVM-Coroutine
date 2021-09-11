package com.example.cocktailmvvmcoroutine.data.model

import java.util.*

data class Ingredient (
    val idIngredient: Long,
    val strIngredient: String,
    val strDescription: String
) {
    fun getThumbnailUrl() =
        "www.thecocktaildb.com/images/ingredients/${strIngredient.lowercase(Locale.getDefault())}-Small.png"
}
