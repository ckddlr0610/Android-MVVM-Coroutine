package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.ResultOf
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MainRepository @Inject constructor(
    val cocktailDao: CocktailDao,
    val cocktailService: CocktailService
) : Repository {
    fun getCocktailList(): Flow<ResultOf<List<Cocktail>>> {
        return flow {
            emit(ResultOf.Loading)
            val cocktails = cocktailDao.getCocktailList()
            if (cocktails.isEmpty()) {
                try {
                    val response = cocktailService.getAlcoholicCocktailList()
                    emit(ResultOf.Success(response.drinks))
                    cocktailDao.insertCocktailList(response.drinks)
                } catch (e: IOException) {
                    emit(ResultOf.Error(e))
                }
            } else {
                emit(ResultOf.Success(cocktails))
            }
        }
    }
}
