package com.geektech.android3dz2.ui.fragments.episode

import androidx.lifecycle.ViewModel
import com.geektech.android3dz2.data.repoitories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
private val episodeRepository: EpisodeRepository
): ViewModel() {

    fun fetchEpisode() = episodeRepository.fetchEpisode()

    fun getAll() = episodeRepository.getAll()
}
