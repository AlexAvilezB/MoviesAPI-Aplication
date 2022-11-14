package com.example.moviesapi.showsList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapi.R
import com.example.moviesapi.data.TVShow
import com.example.moviesapi.data.getPosterURL
import com.example.moviesapi.helpers.setImage

class ShowsListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
    private val posterImageView: ImageView = itemView.findViewById(R.id.tvShowImage)

    fun setTVShow(item: TVShow){
        nameTextView.text = item.name
        posterImageView.setImage(item.getPosterURL())
    }
}