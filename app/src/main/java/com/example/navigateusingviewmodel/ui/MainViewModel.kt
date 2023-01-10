package com.example.navigateusingviewmodel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigateusingviewmodel.data.network.Language
import com.example.navigateusingviewmodel.repository.MainRepo
import com.example.navigateusingviewmodel.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepo) : ViewModel(){
    private val _languageDetect = MutableLiveData<UiState<Pair<String, String>>>()
    val languageDetect: LiveData<UiState<Pair<String, String>>> = _languageDetect

    fun detectLanguage(text: String) = viewModelScope.launch {
        _languageDetect.value = UiState.Loading
        repo.detectLanguage(
            text
        ){
            _languageDetect.value = it
        }
    }
}