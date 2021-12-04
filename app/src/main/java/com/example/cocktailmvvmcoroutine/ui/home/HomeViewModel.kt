package com.example.cocktailmvvmcoroutine.ui.home

import androidx.lifecycle.*
import com.example.cocktailmvvmcoroutine.data.model.Cocktail
import com.example.cocktailmvvmcoroutine.data.model.ResultOf
import com.example.cocktailmvvmcoroutine.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private var pageNum: Int = 0

    private val _showProgress: MutableLiveData<Boolean> = MutableLiveData()

    val showProgress: LiveData<Boolean>
        get() = _showProgress

    private val _showError: MutableLiveData<String> = MutableLiveData()

    val showError: LiveData<String>
        get() = _showError

    private val _cocktails: MutableLiveData<List<Cocktail>> = MutableLiveData(listOf())

    val cocktails: LiveData<List<Cocktail>>
        get() = _cocktails

    fun getCocktailList() = viewModelScope.launch {
        mainRepository.getCocktailList(pageNum)
            .collect { result ->
                when (result) {
                    is ResultOf.Loading -> _showProgress.value = true
                    is ResultOf.Success -> {
                        _showProgress.value = false
                        val preCocktails = _cocktails.value
                        _cocktails.value = preCocktails?.plus(result.item)
                    }
                    is ResultOf.Error -> {
                        _showProgress.value = false
                        _showError.value = result.throwable?.message
                    }
                }
            }
    }

    fun incrementPageNum() {
        pageNum++
    }
}
