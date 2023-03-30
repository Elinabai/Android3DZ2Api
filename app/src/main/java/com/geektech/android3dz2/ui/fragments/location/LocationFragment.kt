package com.geektech.android3dz2.ui.fragments.location

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentLocationBinding
import com.geektech.android3dz2.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment :
    BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private var locationAdapter = LocationAdapter(this::onItemClick)

    override fun initialise() {
        binding.locationRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = locationAdapter
        }
    }

    override fun setupObserve() {
        if (isNetworkAvailable(requireContext())) {
            viewModel.fetchLocation().observe(viewLifecycleOwner) {
                locationAdapter.submitList(it.result)
            }
        } else {
            viewModel.getAll().observe(viewLifecycleOwner) {
                locationAdapter.submitList(it)
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
        findNavController().navigate(LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(
            id))
    }
}