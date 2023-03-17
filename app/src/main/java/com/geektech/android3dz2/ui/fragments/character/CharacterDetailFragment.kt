package com.geektech.android3dz2.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentCharacterDetailBinding
import com.geektech.android3dz2.extension.setImage

class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchCharacterDetail(args.id).observe(viewLifecycleOwner) {
            binding.tvTextGender.id
            binding.tvTextGender.text = args.gender
            binding.tvTextStatus.text = args.status
            binding.tvTextDetail.text = args.name
            binding.imageView.setImage(args.image)
        }
    }
}