package com.geektech.android3dz2.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.android3dz2.databinding.ItemCharacterBinding
import com.geektech.android3dz2.model.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var listCharacter: List<CharacterModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CharacterModel>) {
        this.listCharacter = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(characterModel: CharacterModel) {
            binding.itemCharacterName.text = characterModel.name
            binding.itemCharacterGender.text = characterModel.gender
            binding.itemCharacterStatus.text = characterModel.status
            Glide.with(binding.itemCharacterImage.context).load(characterModel.image)
                .into(binding.itemCharacterImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(
                parent.context
            ), parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listCharacter[position])
    }

    override fun getItemCount(): Int = listCharacter.size
}