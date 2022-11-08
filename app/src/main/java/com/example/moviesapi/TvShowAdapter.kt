package com.example.moviesapi

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import androidx.recyclerview.widget.RecyclerView

class TvShowAdapter(private val dataSet: Array<TVShow>) : RecyclerView.Adapter<TvShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tvshows_items, parent, false)

        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {

        val item = dataSet[position]

        holder.setTVShow(item)
        holder.nameTextView.text = dataSet[position].name
        holder.firstAirTextView.text = dataSet[position].first_air_date
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}