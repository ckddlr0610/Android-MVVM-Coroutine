package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.model.Cocktails
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    val cocktailService: CocktailService
) : Repository {
    override fun fetchCocktailList(): Flow<Result<Cocktails>> {
        //TODO: 로컬에서 먼저 가져오고 없으면 네트워크 요청하기
        return flow {
            emit(Result.Loading)
            try {
                val response = cocktailService.fetchAlcoholicCocktails()
                emit(Result.Success(response))
            } catch (e: IOException) {
                emit(Result.Error(e))
            }
        }
    }
}
