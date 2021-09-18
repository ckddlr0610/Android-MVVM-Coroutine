package com.example.cocktailmvvmcoroutine.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    mainRepository: MainRepository
): ViewModel() {
    private val _cocktails = mainRepository
        .getCocktailList()
        .asLiveData()

    val cocktails : LiveData<Result<List<Cocktail>>>
        get() = _cocktails
}
