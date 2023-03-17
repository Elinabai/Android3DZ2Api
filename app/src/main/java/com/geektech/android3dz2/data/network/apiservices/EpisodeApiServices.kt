package com.geektech.android3dz2.data.network.apiservices

import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiServices {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>

    @GET("/api/episode/{id}")
    fun fetchEpisodeDetail(@Path("id") id: Int): Call<EpisodeModel>
}
