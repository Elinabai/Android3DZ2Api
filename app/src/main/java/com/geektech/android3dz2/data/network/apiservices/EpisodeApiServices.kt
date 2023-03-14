package com.geektech.android3dz2.data.network.apiservices

import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApiServices {
    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>
}
