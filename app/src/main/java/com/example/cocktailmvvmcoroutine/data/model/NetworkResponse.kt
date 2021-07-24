package com.example.cocktailmvvmcoroutine.data.model

sealed class NetworkResponse<out T> {
    class Init : NetworkResponse<Nothing>()
    class Loading : NetworkResponse<Nothing>()
    class Success<out T>(val item: T) : NetworkResponse<T>()
    class Error(val throwable: Throwable?) : NetworkResponse<Nothing>()
}
