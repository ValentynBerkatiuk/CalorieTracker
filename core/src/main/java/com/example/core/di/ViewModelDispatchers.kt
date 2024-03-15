package com.example.core.di

import kotlinx.coroutines.CoroutineDispatcher

data class ViewModelDispatchers(
    override val io: CoroutineDispatcher,
    override val default: CoroutineDispatcher,
    override val unconfined: CoroutineDispatcher,
    override val main: CoroutineDispatcher
): CoroutineDispatchers
