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
        //TODO: 가져온 데이터를 로컬에는 페이지별로 저장할 수 있을까? 다음 로드할때 페이지 별로 가져오기 take 사용해서
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
