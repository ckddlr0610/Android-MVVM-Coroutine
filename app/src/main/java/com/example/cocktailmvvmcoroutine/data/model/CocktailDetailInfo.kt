package com.example.cocktailmvvmcoroutine.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO: strIngredient를 효과적으로 관리할 방법은 없나?
@Entity
data class CocktailDetailInfo(
    @PrimaryKey val idDrink: Long,
    val strDrink: String,
    val strTags: String,
    val strInstructions: String,
    val strDrinkThumb: String,
    val strIngredient1: String? = null,
    val strIngredient2: String? = null,
    val strIngredient3: String? = null,
    val strIngredient4: String? = null,
    val strIngredient5: String? = null,
    val strIngredient6: String? = null,
    val strIngredient7: String? = null,
    val strIngredient8: String? = null,
    val strIngredient9: String? = null
)
