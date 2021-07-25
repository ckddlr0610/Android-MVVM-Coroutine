package com.example.cocktailmvvmcoroutine.di

import android.app.Application
import androidx.room.Room
import com.example.cocktailmvvmcoroutine.data.local.CocktailDatabase
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
    ): CocktailDatabase {
        return Room
            .databaseBuilder(application, CocktailDatabase::class.java, "Cocktail.db")
            .build()
    }
}
