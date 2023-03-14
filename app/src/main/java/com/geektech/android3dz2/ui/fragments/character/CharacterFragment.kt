package com.geektech.android3dz2.ui.fragments.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.android3dz2.databinding.FragmentCharacterBinding
import com.geektech.android3dz2.ui.adapters.CharacterAdapter

class CharacterFragment : Fragment() {

    private var viewModel: CharacterViewModel? = null
    private lateinit var binding: FragmentCharacterBinding
    private var characterAdapter = CharacterAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserve()
    }

    private fun initialize() {
        binding.characterRecView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = characterAdapter
        }
    }

    private fun setupObserve() {
        viewModel?.fetchCharacter()?.observe(viewLifecycleOwner) {
            characterAdapter.setList(it.result)
        }
    }
}