package com.example.moviesapi

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TvShowAdapter(
    private val dataSet: Array<TVShow>,
    private val onTap: (Int) -> Unit,
) : RecyclerView.Adapter<TvShowViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tvshows_items, parent, false)

        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {

        val item = dataSet[position]

        holder.setTVShow(item)
        holder.nameTextView.text = dataSet[position].name
        holder.firstAirTextView.text = dataSet[position].first_air_date

        holder.itemView.setOnClickListener {
            Log.i("OnTap", "Did tap on item with id: " + item.id)

            onTap(item.id)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}