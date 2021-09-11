package com.example.cocktailmvvmcoroutine.repository

import com.example.cocktailmvvmcoroutine.MockData
import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.CocktailResponse
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import com.example.cocktailmvvmcoroutine.data.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainRepositoryTest {
    private lateinit var repository: MainRepository
    private lateinit var service : CocktailService
    private lateinit var cocktailDao : CocktailDao

    @Before
    fun setup() {
        service = mock(CocktailService::class.java)
        cocktailDao = mock(CocktailDao::class.java)
        repository = MainRepository(cocktailDao, service)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getCocktailListFromRemoteTest() = runBlockingTest {
        val mockCocktails = MockData.getMockCocktailList()
        `when`(cocktailDao.getCocktailList()).thenReturn(listOf())
        `when`(service.getAlcoholicCocktailList()).thenReturn(CocktailResponse(listOf(mockCocktails)))

        val result = repository.getCocktailList().drop(1).first()

        assertThat(result, instanceOf(Result.Success::class.java))

        if (result is Result.Success<List<Cocktail>>) {
            assertEquals(result.item[0].idDrink, mockCocktails.idDrink)
            assertEquals(result.item[0].strDrink, mockCocktails.strDrink)
            assertEquals(result.item[0].strDrinkThumb, mockCocktails.strDrinkThumb)
        }

        verify(cocktailDao, atLeast(1)).getCocktailList()
        verify(service, atLeast(1)).getAlcoholicCocktailList()
    }
}
