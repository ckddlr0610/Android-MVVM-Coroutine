package com.example.cocktailmvvmcoroutine.service

import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets

abstract class BaseNetworkServiceTest<T> {
    lateinit var server: MockWebServer
    lateinit var service: CocktailService

    @Before
    fun setup() {
        server = MockWebServer()
        server.start()
    }

    fun createService(clazz: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(clazz)
    }

    fun enqueueMockResponse(fileName: String) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        server.enqueue(mockResponse.setBody(source.readString(StandardCharsets.UTF_8)))
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}
