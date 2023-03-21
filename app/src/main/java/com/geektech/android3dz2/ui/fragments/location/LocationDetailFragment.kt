package com.geektech.android3dz2.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentLocationDetailBinding

class LocationDetailFragment :
    BaseFragment<FragmentLocationDetailBinding, LocationViewModel>(R.layout.fragment_location_detail) {

    override val binding by viewBinding(FragmentLocationDetailBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val args by navArgs<LocationDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchLocationDetail(args.id).observe(viewLifecycleOwner) {
            binding.tvTextName.text = it.name
            binding.tvTextDimension.text = it.dimension
            binding.tvTextType.text = it.type
            binding.tvTextCreated.text = it.created
        }
    }
}