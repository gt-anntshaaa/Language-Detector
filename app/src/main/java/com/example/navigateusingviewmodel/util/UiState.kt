package com.example.navigateusingviewmodel.util

sealed class UiState<out T>{
    object Loading: UiState<Nothing>()
    data class Success<out T>(val value: T): UiState<T>()
    data class Failure(val message: String): UiState<Nothing>()
}
