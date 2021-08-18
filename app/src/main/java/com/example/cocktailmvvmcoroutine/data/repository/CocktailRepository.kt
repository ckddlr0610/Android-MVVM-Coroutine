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
    override fun fetchCocktailList(): Flow<Result<List<Cocktail>>> {
        //TODO: 가져온 데이터를 로컬에는 페이지별로 저장할 수 있을까? 다음 로드할때 페이지 별로 가져오기 take 사용해서
        return flow {
            val cocktails = cocktailDao.getCocktails()

            if (cocktails.isEmpty()) {
                emit(Result.Loading)
                try {
                    val response = cocktailService.fetchAlcoholicCocktails()
                    emit(Result.Success(response.drinks))
                    cocktailDao.insertCocktails(response.drinks)
                } catch (e: IOException) {
                    emit(Result.Error(e))
                }
            } else {
                emit(Result.Success(cocktails))
            }
        }
    }
}
