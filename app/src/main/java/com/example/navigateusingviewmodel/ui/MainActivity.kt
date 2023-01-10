package com.example.navigateusingviewmodel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.navigateusingviewmodel.R
import com.example.navigateusingviewmodel.databinding.ActivityMainBinding
import com.example.navigateusingviewmodel.util.UiState
import com.example.navigateusingviewmodel.util.hide
import com.example.navigateusingviewmodel.util.show
import com.example.navigateusingviewmodel.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idBtnDetectLanguage.setOnClickListener {
            val text = binding.idEdtLanguage.text.toString()
            viewModel.detectLanguage("$text")
        }

        viewModel.languageDetect.observe(this, Observer {state ->
            when(state){
                is UiState.Loading -> {binding.progressBar.show()}
                is UiState.Success -> {
                    binding.progressBar.hide()
                    binding.idTVDetectedLanguageCode.text = state.value.first.toString()
                }
                is UiState.Failure -> {
                    toast("${state.message}")
                }
            }
        })
    }
}