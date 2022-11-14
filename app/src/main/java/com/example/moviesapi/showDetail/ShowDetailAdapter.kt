package com.example.moviesapi.showDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapi.R
import com.example.moviesapi.data.*

class ShowDetailAdapter(
    private val dataSet: ShowDetailResponse
) : RecyclerView.Adapter<ShowDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_show_details_item, parent, false)

        return ShowDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowDetailViewHolder, position: Int) {
        val item = dataSet

        holder.setTVShow(item)
    }

    override fun getItemCount(): Int = 1
}