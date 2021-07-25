package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.model.Cocktails
import com.example.cocktailmvvmcoroutine.data.model.Result
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun fetchCocktailList(): Flow<Result<Cocktails>>
}
