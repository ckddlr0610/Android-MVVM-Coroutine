package com.example.cocktailmvvmcoroutine.data.model

data class DetailUiModel(
    val strDrink: String,
    val strTags: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    var ingredients: List<Ingredient>
)
