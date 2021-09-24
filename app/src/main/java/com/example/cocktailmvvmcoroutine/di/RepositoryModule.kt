package com.example.cocktailmvvmcoroutine.di

import com.example.cocktailmvvmcoroutine.data.local.CocktailDao
import com.example.cocktailmvvmcoroutine.data.local.DetailDao
import com.example.cocktailmvvmcoroutine.data.network.CocktailService
import com.example.cocktailmvvmcoroutine.data.repository.DetailRepository
import com.example.cocktailmvvmcoroutine.data.repository.MainRepository
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
    ) : MainRepository =
        MainRepository(
            cocktailDao,
            cocktailService
        )

    @Provides
    @ActivityRetainedScoped
    fun provideDetailRepository(
        detailDao: DetailDao,
        cocktailService: CocktailService
    ) : DetailRepository =
        DetailRepository(
            detailDao,
            cocktailService
        )
}
