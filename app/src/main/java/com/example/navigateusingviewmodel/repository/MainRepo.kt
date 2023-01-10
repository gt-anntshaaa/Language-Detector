package com.example.navigateusingviewmodel.repository


import com.example.navigateusingviewmodel.util.UiState


interface MainRepo {
    suspend fun detectLanguage(text: String, result: (UiState<Pair<String, String>>) -> Unit)
}