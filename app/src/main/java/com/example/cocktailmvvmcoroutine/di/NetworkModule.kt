package com.example.cocktailmvvmcoroutine.di

import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import com.example.cocktailmvvmcoroutine.data.network.HttpClient
import com.example.cocktailmvvmcoroutine.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(httpClient: HttpClient) =
        Retrofit.Builder()
            .client(httpClient.okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideCocktailService(retrofit: Retrofit) : CocktailService =
        retrofit.create(CocktailService::class.java)
}
