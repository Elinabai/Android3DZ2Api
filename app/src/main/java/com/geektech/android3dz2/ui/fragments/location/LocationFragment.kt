package com.geektech.android3dz2.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentLocationBinding
import com.geektech.android3dz2.ui.adapters.LocationAdapter
import kotlinx.coroutines.launch

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
        lifecycleScope.launch {
            viewModel.fetchLocation().collect {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(
            id))
    }
}
