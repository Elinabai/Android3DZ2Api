package com.geektech.android3dz2.ui.fragments.character

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentCharacterBinding
import com.geektech.android3dz2.ui.adapters.CharacterAdapter
import kotlinx.coroutines.launch

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(R.layout.fragment_character) {

    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by activityViewModels()
    private var characterAdapter = CharacterAdapter(this::onItemClick)

    override fun initialise() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    override fun setupObserve() {
        lifecycleScope.launch {
            viewModel.fetchCharacter().collect {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(
            id))
    }
}