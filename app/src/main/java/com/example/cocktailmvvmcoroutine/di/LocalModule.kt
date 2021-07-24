package com.example.cocktailmvvmcoroutine.di

import android.app.Application
import androidx.room.Room
import com.example.cocktailmvvmcoroutine.data.local.CocktailDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class LocalModule {
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
