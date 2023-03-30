package com.geektech.android3dz2.ui.fragments.episode.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentEpisodeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeDetailFragment :
    BaseFragment<FragmentEpisodeDetailBinding, EpisodeDetailViewModel>(R.layout.fragment_episode_detail) {

    override val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    override val viewModel: EpisodeDetailViewModel by viewModels()
    private val args by navArgs<EpisodeDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchEpisodeDetail(args.id).observe(viewLifecycleOwner) {
            binding.tvTextName.text = it.name
            binding.tvTextEpisode.text = it.episode
            binding.tvTextAirDate.text = it.air_date
            binding.tvTextCreated.text = it.created
        }
    }
}
