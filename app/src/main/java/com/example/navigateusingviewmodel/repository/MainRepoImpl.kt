package com.example.navigateusingviewmodel.repository

import com.example.navigateusingviewmodel.data.network.Language
import com.example.navigateusingviewmodel.util.UiState
import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification
import javax.inject.Inject

class MainRepoImpl @Inject constructor(private val firebaseLanguage: FirebaseLanguageIdentification) : MainRepo {
    override suspend fun detectLanguage(
        text: String,
        result: (UiState<Pair<String, String>>) -> Unit
    ) {
        firebaseLanguage.identifyLanguage(text)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success(Pair(it, "Detect language is success ..."))
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure("Fail to detect language $it")
                )
            }
    }
}