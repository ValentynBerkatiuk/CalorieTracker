package com.example.tracker_data.di

import android.app.Application
import androidx.room.Room
import com.example.tracker_data.remote.OpenFoodApi
import com.example.tracker_data.local.TrackerDataBase
import com.example.tracker_data.repository.TrackerDataRepositoryImpl
import com.example.tracker_domain.repository.TrackerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrackerDataModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()


    @Singleton
    @Provides
    fun provideOpenFoodApi(client: OkHttpClient): OpenFoodApi =
        Retrofit.Builder()
            .baseUrl(OpenFoodApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()


    @Singleton
    @Provides
    fun provideTrackerDataBase(app: Application): TrackerDataBase =
        Room.databaseBuilder(
            context = app,
            klass = TrackerDataBase::class.java,
            name = "tracker_db"
        ).build()

    @Provides
    fun provideTrackerDataRepository(
        api: OpenFoodApi,
        database: TrackerDataBase
    ): TrackerRepository = TrackerDataRepositoryImpl(api = api, dao = database.dao)


}