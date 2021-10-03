package com.example.cocktailmvvmcoroutine.data.model

sealed class ResultOf<out T> {
    object Loading : ResultOf<Nothing>()
    class Success<out T>(val item: T) : ResultOf<T>()
    class Error(val throwable: Throwable?) : ResultOf<Nothing>()
}
