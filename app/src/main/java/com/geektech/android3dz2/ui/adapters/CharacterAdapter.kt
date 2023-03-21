package com.geektech.android3dz2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.geektech.android3dz2.databinding.ItemCharacterBinding
import com.geektech.android3dz2.extension.setImage
import com.geektech.android3dz2.model.CharacterModel

class CharacterAdapter(val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { character -> onItemClick(character.id) }
            }
        }

        fun onBind(item: CharacterModel?) {
            binding.itemCharacterName.text = item?.name
            binding.itemCharacterStatus.text = item?.status
            binding.itemCharacterGender.text = item?.gender
            binding.itemCharacterImage.setImage(item?.image.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}