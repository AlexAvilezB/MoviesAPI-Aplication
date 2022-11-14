package com.example.moviesapi.showsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapi.R
import com.example.moviesapi.data.*

class ShowsListAdapter(
    private val dataSet: Array<TVShow>,
    private val onTap: (Int) -> Unit,
) : RecyclerView.Adapter<ShowsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tvshows_items, parent, false)

        return ShowsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowsListViewHolder, position: Int) {
        val item = dataSet[position]

        holder.setTVShow(item)

        holder.itemView.setOnClickListener {
            onTap(item.id)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}