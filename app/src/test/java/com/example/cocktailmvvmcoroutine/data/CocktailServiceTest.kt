package com.example.cocktailmvvmcoroutine.data

import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets

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
