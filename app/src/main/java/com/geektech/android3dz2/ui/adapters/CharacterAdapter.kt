package com.geektech.android3dz2.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.android3dz2.databinding.ItemCharacterBinding
import com.geektech.android3dz2.extension.setImage
import com.geektech.android3dz2.model.CharacterModel

class CharacterAdapter(val onItemClick: (characterModel: CharacterModel) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var listCharacter: List<CharacterModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CharacterModel>) {
        this.listCharacter = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(listCharacter[bindingAdapterPosition])
            }
        }

        fun onBind(characterModel: CharacterModel) {
            binding.itemCharacterName.text = characterModel.name
            binding.itemCharacterGender.text = characterModel.gender
            binding.itemCharacterStatus.text = characterModel.status
            binding.itemCharacterImage.setImage(characterModel.image)
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