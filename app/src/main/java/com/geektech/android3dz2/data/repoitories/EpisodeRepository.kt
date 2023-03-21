package com.geektech.android3dz2.data.repoitories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.geektech.android3dz2.App
import com.geektech.android3dz2.data.repoitories.pagingsources.EpisodePagingSource
import com.geektech.android3dz2.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

class EpisodeRepository {

    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSource(App.episodeApiServices!!)
            }).flow
    }

    fun fetchEpisodeDetail(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        App.episodeApiServices?.fetchEpisodeDetail(id)
            ?.enqueue(object : retrofit2.Callback<EpisodeModel> {
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
}