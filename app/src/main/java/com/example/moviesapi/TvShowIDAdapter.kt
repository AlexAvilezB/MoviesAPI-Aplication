package com.example.moviesapi

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TvShowIDAdapter(
    private val dataSet: Array<TvShowIdResponse>
) : RecyclerView.Adapter<TvShowIDViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowIDViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tvshows_items, parent, false)

        return TvShowIDViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowIDViewHolder, position: Int) {

        val item = dataSet[position]

        holder.setTVShowID(item)
        holder.showName_textView.text = dataSet[position].name

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}