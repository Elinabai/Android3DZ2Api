package com.geektech.android3dz2.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentCharacterBinding
import com.geektech.android3dz2.model.CharacterModel
import com.geektech.android3dz2.ui.adapters.CharacterAdapter

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private var characterAdapter = CharacterAdapter(this::onItemClick)

    override fun initialise() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchCharacter().observe(viewLifecycleOwner) {
            characterAdapter.setList(it.result)
        }
    }

    private fun onItemClick(characterModel: CharacterModel) {
        findNavController().navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(
            characterModel.name,
            characterModel.image,
            characterModel.status,
            characterModel.gender,
            characterModel.id)
        )
    }
}