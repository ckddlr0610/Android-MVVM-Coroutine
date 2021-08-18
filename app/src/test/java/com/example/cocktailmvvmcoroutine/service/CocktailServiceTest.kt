package com.example.cocktailmvvmcoroutine.service

import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class CocktailServiceTest : BaseNetworkServiceTest<CocktailService>() {
    @Test
    fun test_fetchCocktailList() = runBlocking {
        service = createService(CocktailService::class.java)
        enqueueMockResponse("cocktails.json")
        val response = service.fetchAlcoholicCocktails()
        server.takeRequest()

        assertThat(response.drinks[0].strDrink, `is`("1-900-FUK-MEUP"))
        assertThat(response.drinks[0].idDrink, `is`(15395))
    }
}
