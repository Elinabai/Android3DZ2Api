package com.geektech.android3dz2.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.geektech.android3dz2.databinding.ItemLocationBinding
import com.geektech.android3dz2.model.LocationModel

class LocationAdapter(val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<LocationModel, LocationAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { character -> onItemClick(character.id) }
            }
        }

        fun onBind(item: LocationModel?) {
            binding.itemLocationType.text = item?.type
            binding.itemLocationDimension.text = item?.dimension
            binding.itemLocationName.text = item?.name
            binding.itemLocationCreated.text = item?.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(
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
        private val diffUtil = object : DiffUtil.ItemCallback<LocationModel>() {
            override fun areItemsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
