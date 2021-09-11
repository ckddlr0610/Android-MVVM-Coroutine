package com.example.cocktailmvvmcoroutine.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CocktailDetailInfo(
    @PrimaryKey val idDrink: Long,
    val strDrink: String,
    val strTags: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
)
