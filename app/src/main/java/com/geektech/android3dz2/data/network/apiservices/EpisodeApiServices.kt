package com.geektech.android3dz2.data.network.apiservices

import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import dagger.Provides
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiServices {

    @GET("api/episode")
    fun fetchEpisode(
//        @Query("page") page: Int
    ): Call<RickAndMortyResponse<EpisodeModel>>

//    @GET("api/episode")
//    suspend fun fetchEpisode(@Query("page")page: Int): RickAndMortyResponse<EpisodeModel>

    @GET("api/episode/{id}")
    fun fetchEpisodeDetail(@Path("id") id: Int): Call<EpisodeModel>
}
