package com.example.moviesapi

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TvShowIDAdapter(
    private val dataSet: TvShowIdResponse
) : RecyclerView.Adapter<TvShowIDViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowIDViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_show_details_item, parent, false)

        return TvShowIDViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowIDViewHolder, position: Int) {

        val item = dataSet

        holder.setTVShowID(item)
        holder.showName_textView.text = dataSet.name
        holder.showEpisodes_textView.text = dataSet.number_of_episodes.toString()
        holder.overview_textView.text = dataSet.overview
        holder.showSeasons_textView.text = dataSet.number_of_seasons.toString()


    }

    override fun getItemCount(): Int {
        return 1
    }
}