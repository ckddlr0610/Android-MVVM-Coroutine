package com.example.cocktailmvvmcoroutine.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cocktailmvvmcoroutine.data.model.Cocktails
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    cocktailRepository: Repository
): ViewModel() {
    private val _cocktails = cocktailRepository
        .fetchCocktailList()
        .asLiveData()

    val cocktail : LiveData<Result<Cocktails>>
        get() = _cocktails
}
