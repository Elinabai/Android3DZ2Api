package com.geektech.android3dz2.ui.fragments.character.detail

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.android3dz2.R
import com.geektech.android3dz2.base.BaseFragment
import com.geektech.android3dz2.databinding.FragmentCharacterDetailBinding
import com.geektech.android3dz2.extension.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding, CharacterDetailViewModel>(R.layout.fragment_character_detail) {

    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args by navArgs<CharacterDetailFragmentArgs>()

    override fun setupObserve() {
//        if (isNetworkAvailable(requireContext())) {
            viewModel.fetchCharacterDetail(args.id).observe(viewLifecycleOwner) {
                binding.tvTextGender.text = it.gender
                binding.tvTextStatus.text = it.status
                binding.imageView.setImage(it.image)
                binding.tvTextDetail.text = it.name
            }
//        } else {
//            viewModel.getAll().observe(viewLifecycleOwner) {
//                binding.tvTextGender.text = getString(id)
//                binding.tvTextStatus.text = getString(id)
//                binding.imageView.setImage(getString(id))
//                binding.tvTextDetail.text = getString(id)
//            }
//        }
    }

//    private fun isNetworkAvailable(context: Context): Boolean {
//        val connectivityManager =
//            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork = connectivityManager.activeNetwork ?: return false
//        return connectivityManager.getNetworkCapabilities(activeNetwork)?.run {
//            hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
//        } ?: false
//    }
}