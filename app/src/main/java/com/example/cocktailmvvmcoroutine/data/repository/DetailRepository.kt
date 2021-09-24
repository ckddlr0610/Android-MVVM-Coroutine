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
                    val detailInfoFromNetwork = cocktailService.getCocktailDetailInfo(idDrink)

                    detailDao.insertCocktailDetailInfo(detailInfoFromNetwork)
                    val result = DetailUiModel(
                        detailInfoFromNetwork.strDrink,
                        detailInfoFromNetwork.strTags,
                        detailInfoFromNetwork.strInstructions,
                        detailInfoFromNetwork.strDrinkThumb,
                        listOf()
                    )

                    val ingredients = mutableListOf<Ingredient>()

                    if (!detailInfoFromNetwork.strIngredient1.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient1)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient2.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient2)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient3.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient3)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient4.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient4)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient5.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient5)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient6.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient6)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient7.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient7)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient8.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient8)
                        ingredients.add(ingredient)
                    }

                    if (!detailInfoFromNetwork.strIngredient9.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient9)
                        ingredients.add(ingredient)
                    }

                    result.ingredients = ingredients

                    emit(Result.Success(result))
                } catch (exception: IOException) {
                    emit(Result.Error(exception))
                }
            } else {
                val result = DetailUiModel(
                    detailInfo.strDrink,
                    detailInfo.strTags,
                    detailInfo.strInstructions,
                    detailInfo.strDrinkThumb,
                    listOf()
                )

                val ingredients = mutableListOf<Ingredient>()

                if (!detailInfo.strIngredient1.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient1)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient2.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient2)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient3.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient3)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient4.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient4)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient5.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient5)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient6.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient6)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient7.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient7)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient8.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient8)
                    ingredients.add(ingredient)
                }

                if (!detailInfo.strIngredient9.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient9)
                    ingredients.add(ingredient)
                }

                result.ingredients = ingredients

                emit(Result.Success(result))
            }
        }
    }

    private suspend fun getIngredient(
        strIngredient: String
    ): Ingredient {

        return detailDao.getIngredient(strIngredient)
            ?: try {
                val ingredientFromNetwork =
                    cocktailService.getIngredient(strIngredient.lowercase())

                detailDao.insertIngredient(ingredientFromNetwork)
                ingredientFromNetwork
            } catch (exception: IOException) {
                throw exception
            }
    }
}
