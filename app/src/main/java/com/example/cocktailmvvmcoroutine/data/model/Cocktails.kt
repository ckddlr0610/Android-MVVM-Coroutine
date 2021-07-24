package com.example.cocktailmvvmcoroutine.data.model

data class Cocktails(
    val drinks: List<Cocktail>
) {
    data class Cocktail(
        val strDrink: String,
        val strDrinkThumb: String,
        val idDrink: Long
    )
}
