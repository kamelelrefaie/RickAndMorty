package com.example.rickandmorty.di

import com.example.rickandmorty.feature_main.common.Constants
import com.example.rickandmorty.feature_main.data.remote.RickAndMortyApi
import com.example.rickandmorty.feature_main.data.repository.RickAndMortyRepositoryImpl
import com.example.rickandmorty.feature_main.domain.repository.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickApi(): RickAndMortyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickRepository(api: RickAndMortyApi): RickAndMortyRepository {
        return RickAndMortyRepositoryImpl(api)
    }
}