package com.example.cocktailmvvmcoroutine.data.repository

import com.example.cocktailmvvmcoroutine.data.local.DetailDao
import com.example.cocktailmvvmcoroutine.data.model.DetailUiModel
import com.example.cocktailmvvmcoroutine.data.model.Ingredient
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import com.example.cocktailmvvmcoroutine.data.model.Result
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
                        detailInfoFromNetwork.strDrinkThumb
                    )

                    if (!detailInfoFromNetwork.strIngredient1.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient1)
                        result.strIngredientInstructions1 = ingredient.strDescription
                        result.strIngredientThumb1 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient2.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient2)
                        result.strIngredientInstructions2 = ingredient.strDescription
                        result.strIngredientThumb2 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient3.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient3)
                        result.strIngredientInstructions3 = ingredient.strDescription
                        result.strIngredientThumb3 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient4.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient4)
                        result.strIngredientInstructions4 = ingredient.strDescription
                        result.strIngredientThumb4 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient5.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient5)
                        result.strIngredientInstructions5 = ingredient.strDescription
                        result.strIngredientThumb5 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient6.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient6)
                        result.strIngredientInstructions6 = ingredient.strDescription
                        result.strIngredientThumb6 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient7.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient7)
                        result.strIngredientInstructions7 = ingredient.strDescription
                        result.strIngredientThumb7 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient8.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient8)
                        result.strIngredientInstructions8 = ingredient.strDescription
                        result.strIngredientThumb8 = ingredient.getThumbnailUrl()
                    }

                    if (!detailInfoFromNetwork.strIngredient9.isNullOrEmpty()) {
                        val ingredient = getIngredient(detailInfoFromNetwork.strIngredient9)
                        result.strIngredientInstructions9 = ingredient.strDescription
                        result.strIngredientThumb9 = ingredient.getThumbnailUrl()
                    }

                    emit(Result.Success(result))
                } catch (exception: IOException) {
                    emit(Result.Error(exception))
                }
            } else {
                val result = DetailUiModel(
                    detailInfo.strDrink,
                    detailInfo.strTags,
                    detailInfo.strInstructions,
                    detailInfo.strDrinkThumb
                )

                if (!detailInfo.strIngredient1.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient1)
                    result.strIngredientInstructions1 = ingredient.strDescription
                    result.strIngredientThumb1 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient2.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient2)
                    result.strIngredientInstructions2 = ingredient.strDescription
                    result.strIngredientThumb2 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient3.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient3)
                    result.strIngredientInstructions3 = ingredient.strDescription
                    result.strIngredientThumb3 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient4.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient4)
                    result.strIngredientInstructions4 = ingredient.strDescription
                    result.strIngredientThumb4 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient5.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient5)
                    result.strIngredientInstructions5 = ingredient.strDescription
                    result.strIngredientThumb5 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient6.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient6)
                    result.strIngredientInstructions6 = ingredient.strDescription
                    result.strIngredientThumb6 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient7.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient7)
                    result.strIngredientInstructions7 = ingredient.strDescription
                    result.strIngredientThumb7 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient8.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient8)
                    result.strIngredientInstructions8 = ingredient.strDescription
                    result.strIngredientThumb8 = ingredient.getThumbnailUrl()
                }

                if (!detailInfo.strIngredient9.isNullOrEmpty()) {
                    val ingredient = getIngredient(detailInfo.strIngredient9)
                    result.strIngredientInstructions9 = ingredient.strDescription
                    result.strIngredientThumb9 = ingredient.getThumbnailUrl()
                }

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
