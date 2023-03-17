package com.geektech.android3dz2.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentEpisodeBinding
import com.geektech.android3dz2.model.EpisodeModel
import com.geektech.android3dz2.ui.adapters.EpisodeAdapter

class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private var episodeAdapter = EpisodeAdapter(this::onItemClick)

    override fun initialise() {
        binding.episodeRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchEpisode().observe(viewLifecycleOwner) {
            episodeAdapter.setList(it.result)
        }
    }

    private fun onItemClick(episodeModel: EpisodeModel) {
        findNavController().navigate(EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(
            episodeModel.name,
            episodeModel.air_date,
            episodeModel.created,
            episodeModel.episode,
            episodeModel.id)
        )
    }
}