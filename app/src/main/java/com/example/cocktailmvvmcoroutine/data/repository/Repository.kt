package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.Result
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun fetchCocktailList(): Flow<Result<List<Cocktail>>>
}
