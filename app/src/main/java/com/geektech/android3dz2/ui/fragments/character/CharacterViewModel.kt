package com.geektech.android3dz2.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.App
import com.geektech.android3dz2.model.CharacterModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()
        App.characterApiServices?.fetchCharacter()
            ?.enqueue(object : retrofit2.Callback<RickAndMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }
}