package com.geektech.android3dz2.ui.fragments.character.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.geektech.android3dz2.databinding.FragmentCharacterFilterBinding
import com.geektech.android3dz2.ui.fragments.character.CharacterViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CharacterFilterFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCharacterFilterBinding
    private val viewModel: CharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCharacterFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnApply.setOnClickListener {
            when (true) {
                binding.chipAlive.isChecked and binding.radioFemale.isChecked -> {
                    viewModel.fetchCharacter("alive", "female")
                }
                binding.chipDead.isChecked and binding.radioFemale.isChecked -> {
                    viewModel.fetchCharacter("dead", "female")
                }
                binding.chipUnknown.isChecked and binding.radioFemale.isChecked -> {
                    viewModel.fetchCharacter("unknown", "female")
                }
                binding.chipAlive.isChecked and binding.radioMale.isChecked -> {
                    viewModel.fetchCharacter("alive", "male")
                }
                binding.chipDead.isChecked and binding.radioMale.isChecked -> {
                    viewModel.fetchCharacter("dead", "male")
                }
                binding.chipUnknown.isChecked and binding.radioMale.isChecked -> {
                    viewModel.fetchCharacter("unknown", "male")
                }
                binding.chipAlive.isChecked and binding.radioGenderLess.isChecked -> {
                    viewModel.fetchCharacter("alive", "genderless")
                }
                binding.chipDead.isChecked and binding.radioGenderLess.isChecked -> {
                    viewModel.fetchCharacter("dead", "genderless")
                }
                binding.chipUnknown.isChecked and binding.radioGenderLess.isChecked -> {
                    viewModel.fetchCharacter("unknown", "genderless")
                }
                binding.chipAlive.isChecked and binding.radioUnknown.isChecked -> {
                    viewModel.fetchCharacter("alive", "unknown")
                }
                binding.chipDead.isChecked and binding.radioUnknown.isChecked -> {
                    viewModel.fetchCharacter("dead", "unknown")
                }
                binding.chipUnknown.isChecked and binding.radioUnknown.isChecked -> {
                    viewModel.fetchCharacter("unknown", "unknown")
                }
                binding.chipAlive.isChecked -> {
                    viewModel.fetchCharacter("alive", "")
                }
                binding.chipDead.isChecked -> {
                    viewModel.fetchCharacter("dead", "")
                }
                binding.chipUnknown.isChecked -> {
                    viewModel.fetchCharacter("unknown", "")
                }
                binding.radioFemale.isChecked -> {
                    viewModel.fetchCharacter("", "female")
                }
                binding.radioMale.isChecked -> {
                    viewModel.fetchCharacter("", "male")
                }
                binding.radioGenderLess.isChecked -> {
                    viewModel.fetchCharacter("", "genderLess")
                }
                binding.radioUnknown.isChecked -> {
                    viewModel.fetchCharacter("", "unknown")
                }
                else -> {
                    viewModel.fetchCharacter("", "")
                }
            }
            findNavController().navigateUp()
        }
    }
}