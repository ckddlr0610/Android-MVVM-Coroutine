package com.example.cocktailmvvmcoroutine.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Ingredient (
    @PrimaryKey val idIngredient: Long,
    var strIngredient: String,
    val strDescription: String?
) {
    fun getThumbnailUrl() =
        "www.thecocktaildb.com/images/ingredients/${strIngredient?.lowercase(Locale.getDefault())}-Small.png"
}
