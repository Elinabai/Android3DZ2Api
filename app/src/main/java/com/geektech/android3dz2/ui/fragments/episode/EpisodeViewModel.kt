package com.geektech.android3dz2.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.geektech.android3dz2.data.repoitories.EpisodeRepository
import com.geektech.android3dz2.model.EpisodeModel

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode() = episodeRepository.fetchEpisode().cachedIn(viewModelScope)

    fun fetchEpisodeDetail(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchEpisodeDetail(id)
    }
}
