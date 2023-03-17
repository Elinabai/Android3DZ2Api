package com.geektech.android3dz2.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.App
import com.geektech.android3dz2.data.repoitories.CharacterRepository
import com.geektech.android3dz2.data.repoitories.EpisodeRepository
import com.geektech.android3dz2.model.CharacterModel
import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.model.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        return episodeRepository.fetchEpisode()
    }

    fun fetchEpisodeDetail(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchEpisodeDetail(id)
    }
}
