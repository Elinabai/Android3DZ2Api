package com.geektech.android3dz2.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.App
import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        App.episodeApiServices?.fetchEpisode()
            ?.enqueue(object : retrofit2.Callback<RickAndMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }
                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }
}
