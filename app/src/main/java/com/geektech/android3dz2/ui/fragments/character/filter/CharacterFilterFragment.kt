package com.geektech.android3dz2.ui.fragments.character.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.android3dz2.databinding.FragmentCharacterFilterBinding
import com.geektech.android3dz2.extension.setBackStackData
import com.geektech.android3dz2.model.Filter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFilterFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCharacterFilterBinding

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
                    setBackStackData("filter", Filter("alive", "female"))
                }
                binding.chipDead.isChecked and binding.radioFemale.isChecked -> {
                    setBackStackData("filter", Filter("dead", "female"))
                }
                binding.chipUnknown.isChecked and binding.radioFemale.isChecked -> {
                    setBackStackData("filter", Filter("unknown", "female"))
                }
                binding.chipAlive.isChecked and binding.radioMale.isChecked -> {
                    setBackStackData("filter", Filter("alive", "male"))
                }
                binding.chipDead.isChecked and binding.radioMale.isChecked -> {
                    setBackStackData("filter", Filter("dead", "male"))
                }
                binding.chipUnknown.isChecked and binding.radioMale.isChecked -> {
                    setBackStackData("filter", Filter("unknown", "male"))
                }
                binding.chipAlive.isChecked and binding.radioGenderLess.isChecked -> {
                    setBackStackData("filter", Filter("alive", "genderless"))
                }
                binding.chipDead.isChecked and binding.radioGenderLess.isChecked -> {
                    setBackStackData("filter", Filter("dead", "genderless"))
                }
                binding.chipUnknown.isChecked and binding.radioGenderLess.isChecked -> {
                    setBackStackData("filter", Filter("unknown", "genderless"))
                }
                binding.chipAlive.isChecked and binding.radioUnknown.isChecked -> {
                    setBackStackData("filter", Filter("alive", "unknown"))
                }
                binding.chipDead.isChecked and binding.radioUnknown.isChecked -> {
                    setBackStackData("filter", Filter("dead", "unknown"))
                }
                binding.chipUnknown.isChecked and binding.radioUnknown.isChecked -> {
                    setBackStackData("filter", Filter("unknown", "unknown"))
                }
                binding.chipAlive.isChecked -> {
                    setBackStackData("filter", Filter("alive", ""))
                }
                binding.chipDead.isChecked -> {
                    setBackStackData("filter", Filter("dead", ""))
                }
                binding.chipUnknown.isChecked -> {
                    setBackStackData("filter", Filter("unknown", ""))
                }
                binding.radioFemale.isChecked -> {
                    setBackStackData("filter", Filter("", "female"))
                }
                binding.radioMale.isChecked -> {
                    setBackStackData("filter", Filter("", "male"))
                }
                binding.radioGenderLess.isChecked -> {
                    setBackStackData("filter", Filter("", "genderLess"))
                }
                binding.radioUnknown.isChecked -> {
                    setBackStackData("filter", Filter("", "unknown"))
                }
                else -> {
                    setBackStackData("filter", Filter("", ""))
                }
            }
        }
    }
}