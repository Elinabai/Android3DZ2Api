package com.geektech.android3dz2.data.network.apiservices

import com.geektech.android3dz2.model.CharacterModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiServices {

    @GET("api/character")
    suspend fun fetchCharacter(
        @Query("page") page: Int,
        @Query("status") status: String,
        @Query("gender") gender: String,
    ): RickAndMortyResponse<CharacterModel>

    @GET("api/character/{id}")
    fun fetchCharactersDetail(@Path("id") id: Int): Call<CharacterModel>
}