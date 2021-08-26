package com.example.cocktailmvvmcoroutine.di

import android.app.Application
import androidx.room.Room
import com.example.cocktailmvvmcoroutine.data.local.AppDatabase
import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "Cocktail.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideCocktailDao(
        appDatabase: AppDatabase
    ): CocktailDao =
        appDatabase.cocktailDao()
}
