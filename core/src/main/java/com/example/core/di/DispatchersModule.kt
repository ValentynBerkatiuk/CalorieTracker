package com.example.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object DispatchersModule {

    @Provides
    fun provideDispatchers(): CoroutineDispatchers = ViewModelDispatchers(
        io = Dispatchers.IO,
        default = Dispatchers.Default,
        main = Dispatchers.Main,
        unconfined = Dispatchers.Unconfined
    )

}