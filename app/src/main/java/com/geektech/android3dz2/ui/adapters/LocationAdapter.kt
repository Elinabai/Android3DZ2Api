package com.geektech.android3dz2.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.android3dz2.databinding.ItemLocationBinding
import com.geektech.android3dz2.model.LocationModel

class LocationAdapter(val onItemClick: (locationModel: LocationModel) -> Unit) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var listLocation: List<LocationModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<LocationModel>) {
        this.listLocation = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private var binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(listLocation[bindingAdapterPosition])
            }
        }

        fun onBind(locationModel: LocationModel) {
            binding.itemLocationCreated.text = locationModel.created
            binding.itemLocationName.text = locationModel.name
            binding.itemLocationType.text = locationModel.type
            binding.itemLocationDimension.text = locationModel.dimension
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(
                parent.context
            ), parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listLocation[position])
    }

    override fun getItemCount(): Int = listLocation.size
}