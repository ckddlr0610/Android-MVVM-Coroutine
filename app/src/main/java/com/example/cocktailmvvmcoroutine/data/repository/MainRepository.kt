package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MainRepository @Inject constructor(
    val cocktailDao: CocktailDao,
    val cocktailService: CocktailService
) : Repository {
    fun getCocktailList(): Flow<Result<List<Cocktail>>> {
        return flow {
            emit(Result.Loading)
            val cocktails = cocktailDao.getCocktailList()
            if (cocktails.isEmpty()) {
                try {
                    val response = cocktailService.getAlcoholicCocktailList()
                    emit(Result.Success(response.drinks))
                    cocktailDao.insertCocktailList(response.drinks)
                } catch (e: IOException) {
                    emit(Result.Error(e))
                }
            } else {
                emit(Result.Success(cocktails))
            }
        }
    }
}
