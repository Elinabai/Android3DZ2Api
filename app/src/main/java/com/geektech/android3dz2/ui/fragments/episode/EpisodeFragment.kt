package com.geektech.android3dz2.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentEpisodeBinding
import com.geektech.android3dz2.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            viewModel.fetchEpisode().collect {
                episodeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(
            id))
    }
}