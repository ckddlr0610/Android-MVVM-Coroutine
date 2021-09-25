package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.local.DetailDao
import com.example.cocktailmvvmcoroutine.data.model.DetailUiModel
import com.example.cocktailmvvmcoroutine.data.model.Ingredient
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DetailRepository @Inject constructor(
    val detailDao: DetailDao,
    val cocktailService: CocktailService
) : Repository {
    fun getDetailUiModel(idDrink: Long): Flow<Result<DetailUiModel>> {
        return flow {
            emit(Result.Loading)
            val detailInfo = detailDao.getCocktailDetailInfo(idDrink)
            if (detailInfo == null) {
                try {
                    val detailInfoFromNetwork = cocktailService.getCocktailDetailInfo(idDrink).drinks[0]

                    detailDao.insertCocktailDetailInfo(detailInfoFromNetwork)
                    val result = DetailUiModel(
                        detailInfoFromNetwork.strDrink ?: "",
                        detailInfoFromNetwork.strTags ?: "",
                        detailInfoFromNetwork.strInstructions ?: "",
                        detailInfoFromNetwork.strDrinkThumb ?: "",
                        listOf()
                    )

                    val ingredients = mutableListOf<Ingredient>()

                    if (!detailInfoFromNetwork.strIngredient1.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient1, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient2.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient2, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient3.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient3, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient4.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient4, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient5.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient5, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient6.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient6, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient7.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient7, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient8.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient8, ingredients)
                    }

                    if (!detailInfoFromNetwork.strIngredient9.isNullOrEmpty()) {
                        addIngredientToIngredientList(detailInfoFromNetwork.strIngredient9, ingredients)
                    }

                    result.ingredients = ingredients

                    emit(Result.Success(result))
                } catch (exception: IOException) {
                    emit(Result.Error(exception))
                }
            } else {
                val result = DetailUiModel(
                    detailInfo.strDrink ?: "",
                    detailInfo.strTags ?: "",
                    detailInfo.strInstructions ?: "",
                    detailInfo.strDrinkThumb ?: "",
                    listOf()
                )

                val ingredients = mutableListOf<Ingredient>()

                if (!detailInfo.strIngredient1.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient1, ingredients)
                }

                if (!detailInfo.strIngredient2.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient2, ingredients)
                }

                if (!detailInfo.strIngredient3.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient3, ingredients)
                }

                if (!detailInfo.strIngredient4.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient4, ingredients)
                }

                if (!detailInfo.strIngredient5.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient5, ingredients)
                }

                if (!detailInfo.strIngredient6.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient6, ingredients)
                }

                if (!detailInfo.strIngredient7.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient7, ingredients)
                }

                if (!detailInfo.strIngredient8.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient8, ingredients)
                }

                if (!detailInfo.strIngredient9.isNullOrEmpty()) {
                    addIngredientToIngredientList(detailInfo.strIngredient9, ingredients)
                }

                result.ingredients = ingredients

                emit(Result.Success(result))
            }
        }
    }

    private suspend fun addIngredientToIngredientList(
        strIngredient: String,
        ingredients: MutableList<Ingredient>
    ) {
        val ingredient = getIngredient(strIngredient)
        ingredients.add(ingredient)
    }

    // TODO: API 문제로 String을 Db 키로 사용하고 있는데 Id로 사용할 방법은 없는지, String을 사용했을 때 디버깅과 관리가 어렵다.
    private suspend fun getIngredient(
        strIngredient: String
    ): Ingredient {
        val ingredient = detailDao.getIngredient(strIngredient.lowercase())
        return if (ingredient == null) {
            val ingredientFromNetwork =
                cocktailService.getIngredient(strIngredient.lowercase()).ingredients[0]

            ingredientFromNetwork.strIngredient = ingredientFromNetwork.strIngredient.lowercase()
            detailDao.insertIngredient(ingredientFromNetwork)
            ingredientFromNetwork
        } else {
            ingredient
        }
    }
}
