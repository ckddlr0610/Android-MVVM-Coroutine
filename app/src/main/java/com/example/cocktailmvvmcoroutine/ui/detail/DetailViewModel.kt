package com.example.cocktailmvvmcoroutine.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.cocktailmvvmcoroutine.data.model.DetailUiModel
import com.example.cocktailmvvmcoroutine.data.model.Result
import com.example.cocktailmvvmcoroutine.data.repository.DetailRepository
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailRepository: DetailRepository
) : ViewModel() {
    private var _detailUiModel: LiveData<Result<DetailUiModel>> = MutableLiveData()

    val detailUiModel : LiveData<Result<DetailUiModel>>
        get() = _detailUiModel

    fun getDetailUiModel(idDrink: Long) {
        _detailUiModel =
            detailRepository.getDetailUiModel(idDrink).asLiveData()
    }
}
