package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.ResultOf
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class MainRepository @Inject constructor(
    val cocktailDao: CocktailDao,
    val cocktailService: CocktailService
) : Repository {
    fun getCocktailList(pageNum: Int): Flow<ResultOf<List<Cocktail>>> {
        return flow {
            emit(ResultOf.Loading)
            val cocktailsSub = cocktailDao.getCocktailListPerPage(pageNum * NUM_CONTENTS_PER_PAGE, ((pageNum + 1) * NUM_CONTENTS_PER_PAGE) - 1)
            if (cocktailsSub.isEmpty()) {
                try {
                    val response = cocktailService.getAlcoholicCocktailList()
                    emit(ResultOf.Success(response.drinks.subList(0, NUM_CONTENTS_PER_PAGE)))
                    cocktailDao.insertCocktailList(response.drinks)
                } catch (e: IOException) {
                    emit(ResultOf.Error(e))
                }
            } else {
                emit(ResultOf.Success(cocktailsSub))
            }
        }
    }

    companion object {
        const val NUM_CONTENTS_PER_PAGE = 20
    }
}
