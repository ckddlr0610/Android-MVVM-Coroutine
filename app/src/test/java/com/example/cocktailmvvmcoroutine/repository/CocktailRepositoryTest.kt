package com.example.cocktailmvvmcoroutine.repository

import com.example.cocktailmvvmcoroutine.MockData
import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.CocktailResponse
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import com.example.cocktailmvvmcoroutine.data.repository.CocktailRepository
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
class CocktailRepositoryTest {
    private lateinit var repository: CocktailRepository
    private lateinit var service : CocktailService
    private lateinit var cocktailDao : CocktailDao

    @Before
    fun setup() {
        service = mock(CocktailService::class.java)
        cocktailDao = mock(CocktailDao::class.java)
        repository = CocktailRepository(cocktailDao, service)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun fetchCocktailsFromRemoteTest() = runBlockingTest {
        val mockCocktails = MockData.getMockCocktailsFromNetwork()
        `when`(cocktailDao.getCocktails()).thenReturn(listOf())
        `when`(service.fetchAlcoholicCocktails()).thenReturn(CocktailResponse(listOf(mockCocktails)))

        val result = repository.fetchCocktailList().drop(1).first()

        assertThat(result, instanceOf(Result.Success::class.java))

        if (result is Result.Success<List<Cocktail>>) {
            assertEquals(result.item[0].idDrink, mockCocktails.idDrink)
            assertEquals(result.item[0].strDrink, mockCocktails.strDrink)
            assertEquals(result.item[0].strDrinkThumb, mockCocktails.strDrinkThumb)
        }

        verify(cocktailDao, atLeast(1)).getCocktails()
        verify(service, atLeast(1)).fetchAlcoholicCocktails()
    }
}
