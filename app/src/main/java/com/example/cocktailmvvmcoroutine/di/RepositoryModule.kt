package com.example.cocktailmvvmcoroutine.di

import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import com.example.cocktailmvvmcoroutine.data.repository.MainRepository
import com.example.cocktailmvvmcoroutine.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideRepository(
        cocktailDao: CocktailDao,
        cocktailService: CocktailService
    ) : Repository =
        MainRepository(
            cocktailDao,
            cocktailService
        )
}
