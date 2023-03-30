package com.geektech.android3dz2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.geektech.android3dz2.databinding.ItemEpisodeBinding
import com.geektech.android3dz2.model.EpisodeModel

class EpisodeAdapter(val onItemClick: (id: Int) -> Unit) :
    ListAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { character -> onItemClick(character.id) }
            }
        }

        fun onBind(item: EpisodeModel?) {
            binding.itemEpisodeCreated.text = item?.created
            binding.itemEpisodeEpisode.text = item?.episode
            binding.itemEpisodeAirDate.text = item?.air_date
            binding.itemLocationName.text = item?.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(
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
        private val diffUtil = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: EpisodeModel,
                newItem: EpisodeModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}