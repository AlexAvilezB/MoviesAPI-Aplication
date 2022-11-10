package com.example.moviesapi

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TvShowViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
    val posterPathImageView: ImageView = itemView.findViewById(R.id.tvShowImage)


    fun setTVShow(tvShow:TVShow){
        Glide.with(posterPathImageView.context).load("https://image.tmdb.org/t/p/w500" + tvShow.poster_path).into(posterPathImageView)

    }
}