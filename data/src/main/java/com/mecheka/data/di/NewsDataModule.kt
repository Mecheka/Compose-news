package com.mecheka.data.di

import com.mecheka.data.BuildConfig
import com.mecheka.data.api.NewsApi
import com.mecheka.data.repository.NewsRepository
import com.mecheka.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsDataModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    fun provideNewsRepository(impl: NewsRepositoryImpl): NewsRepository = impl
}