package com.geektech.android3dz2.ui.fragments.character.detail

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentCharacterDetailBinding
import com.geektech.android3dz2.extension.setImage
import com.geektech.android3dz2.ui.fragments.character.CharacterViewModel

class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserve() {
        viewModel.fetchCharacterDetail(args.id).observe(viewLifecycleOwner) {
            binding.tvTextGender.text = it.gender
            binding.tvTextStatus.text = it.status
            binding.imageView.setImage(it.image)
            binding.tvTextDetail.text = it.name
        }
    }
}