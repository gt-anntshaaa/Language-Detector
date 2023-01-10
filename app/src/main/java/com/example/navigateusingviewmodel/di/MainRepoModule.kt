package com.example.navigateusingviewmodel.di

import com.example.navigateusingviewmodel.repository.MainRepo
import com.example.navigateusingviewmodel.repository.MainRepoImpl
import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainRepoModule {
    @Provides
    @Singleton
    fun provideMainRepo(firebaseLanguage: FirebaseLanguageIdentification) : MainRepo{
        return MainRepoImpl(firebaseLanguage)
    }
}