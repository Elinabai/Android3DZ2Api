package com.geektech.android3dz2.di

import com.geektech.android3dz2.data.network.RetrofitClient
import com.geektech.android3dz2.data.network.apiservices.CharacterApiServices
import com.geektech.android3dz2.data.network.apiservices.EpisodeApiServices
import com.geektech.android3dz2.data.network.apiservices.LocationApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun providerCharacterApiServices(): CharacterApiServices{
        return retrofitClient.provideCharacterApiServices()
    }


    @Singleton
    @Provides
    fun providerEpisodeApiServices(): EpisodeApiServices{
        return retrofitClient.provideEpisodeApiServices()
    }

    @Singleton
    @Provides
    fun providerLocationApiServices(): LocationApiServices{
        return retrofitClient.provideLocationApiServices()
    }
}