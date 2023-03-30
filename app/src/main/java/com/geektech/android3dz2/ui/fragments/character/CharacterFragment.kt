package com.geektech.android3dz2.ui.fragments.character

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentCharacterBinding
import com.geektech.android3dz2.extension.getBackStackData
import com.geektech.android3dz2.model.Filter
import com.geektech.android3dz2.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        if (isNetworkAvailable(requireContext())) {
            viewModel.fetchCharacter("", "").observe(viewLifecycleOwner) {
                characterAdapter.submitList(it.result)
            }
        } else {
            viewModel.getAll().observe(viewLifecycleOwner) {
                characterAdapter.submitList(it)
            }
        }

        getBackStackData<Filter>("filter") { filter ->
            viewModel.fetchCharacter(filter.status, filter.gender).observe(viewLifecycleOwner) {
                characterAdapter.submitList(it.result)
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
        findNavController().navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(id))
    }

    override fun setupListener() {
        binding.characterBtnFilter.setOnClickListener {
            findNavController().navigate(R.id.action_characterFragment_to_characterFilterFragment)
        }
    }
}