package com.example.cocktailmvvmcoroutine.data.network

import com.example.cocktailmvvmcoroutine.data.model.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {
    @GET("api/json/v1/1/filter.php?a=Alcoholic")
    suspend fun getAlcoholicCocktailList(
        @Query("a") alcoholic: String = "Alcoholic"
    ): CocktailResponse
}
