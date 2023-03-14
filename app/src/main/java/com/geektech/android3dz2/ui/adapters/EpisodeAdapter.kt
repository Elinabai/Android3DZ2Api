package com.geektech.android3dz2.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.android3dz2.databinding.ItemEpisodeBinding
import com.geektech.android3dz2.model.EpisodeModel

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    private var listEpisode: List<EpisodeModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<EpisodeModel>) {
        this.listEpisode = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(episodeModel: EpisodeModel) {
            binding.itemEpisodeEpisode.text = episodeModel.episode
            binding.itemEpisodeAirDate.text = episodeModel.air_date
            binding.itemEpisodeCreated.text = episodeModel.created
            binding.itemLocationName.text = episodeModel.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(
                parent.context
            ), parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listEpisode[position])
    }

    override fun getItemCount(): Int = listEpisode.size
}
