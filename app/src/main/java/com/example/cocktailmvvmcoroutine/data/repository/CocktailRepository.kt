package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    val cocktailDao: CocktailDao,
    val cocktailService: CocktailService
) : Repository {
    override fun getCocktailList(): Flow<Result<List<Cocktail>>> {
        return flow {
            val cocktails = cocktailDao.getCocktailList()

            if (cocktails.isEmpty()) {
                emit(Result.Loading)
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
