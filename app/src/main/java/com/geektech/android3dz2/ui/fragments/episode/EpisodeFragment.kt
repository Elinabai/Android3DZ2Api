package com.geektech.android3dz2.ui.fragments.episode

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentEpisodeBinding
import com.geektech.android3dz2.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        if (isNetworkAvailable(requireContext())){
            viewModel.fetchEpisode().observe(viewLifecycleOwner) {
                episodeAdapter.submitList(it.result)
            }
        }else{
            viewModel.getAll().observe(viewLifecycleOwner){
                episodeAdapter.submitList(it)
            }
        }
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        return connectivityManager.getNetworkCapabilities(activeNetwork)?.run {
            hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        } ?: false
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(
            id))
    }
}