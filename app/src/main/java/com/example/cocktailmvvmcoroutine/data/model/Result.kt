package com.example.cocktailmvvmcoroutine.data.model

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    class Success<out T>(val item: T) : Result<T>()
    class Error(val throwable: Throwable?) : Result<Nothing>()
}
