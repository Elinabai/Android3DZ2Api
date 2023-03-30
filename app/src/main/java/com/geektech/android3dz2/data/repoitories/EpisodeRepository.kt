package com.geektech.android3dz2.data.repoitories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.android3dz2.data.db.daos.EpisodeDao
import com.geektech.android3dz2.data.network.apiservices.EpisodeApiServices
import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeApiServices: EpisodeApiServices,
    private val episodeDao: EpisodeDao,
) {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        episodeApiServices.fetchEpisode()
            .enqueue(object : retrofit2.Callback<RickAndMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>,
                ) {
                    if (response.body() != null) {
                        response.body().let {
                            it?.let { it1 -> episodeDao.insertAll(it1.result) }
                        }
                    }
                    data.value = response.body()
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

    fun fetchEpisodeDetail(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        episodeApiServices.fetchEpisodeDetail(id)
            .enqueue(object : retrofit2.Callback<EpisodeModel> {
                override fun onResponse(
                    call: Call<EpisodeModel>,
                    response: Response<EpisodeModel>,
                ) {
                    response.body()?.let {
                        data.value = it
                    }
                }

                override fun onFailure(
                    call: Call<EpisodeModel>,
                    t: Throwable,
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun getAll(): LiveData<List<EpisodeModel>> {
        return episodeDao.getAll()
    }
}