package com.geektech.android3dz2.data.network

import com.geektech.android3dz2.data.network.apiservices.CharacterApiServices
import com.geektech.android3dz2.data.network.apiservices.EpisodeApiServices
import com.geektech.android3dz2.data.network.apiservices.LocationApiServices
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharacterApiServices(): CharacterApiServices {
        return retrofitClient.create(CharacterApiServices::class.java)
    }

    fun provideLocationApiServices(): LocationApiServices {
        return retrofitClient.create(LocationApiServices::class.java)
    }

    fun provideEpisodeApiServices(): EpisodeApiServices {
        return retrofitClient.create(EpisodeApiServices::class.java)
    }
}