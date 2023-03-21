package com.geektech.android3dz2.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentEpisodeDetailBinding

class EpisodeDetailFragment :
    BaseFragment<FragmentEpisodeDetailBinding, EpisodeViewModel>(R.layout.fragment_episode_detail) {

    override val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
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
