package com.example.calorietracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.core.data.preferences.DefaultPreferences
import com.example.core.data.preferences.SettingsPreferences
import com.example.core.domain.preferences.Preferences
import com.example.core.domain.use_case.FilterOutDigits
import com.example.core.domain.preferences.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences =
       application.getSharedPreferences("shared_preferences", MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences =
        DefaultPreferences(sharedPreferences = sharedPreferences)

    @Provides
    @Singleton
    fun provideSettingsPreferences(sharedPreferences: SharedPreferences): SettingsRepository =
        SettingsPreferences(sharedPreferences = sharedPreferences)

    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits = FilterOutDigits()
}