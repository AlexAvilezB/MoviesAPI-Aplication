package com.example.moviesapi

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TvShowIDViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val showName_textView: TextView = itemView.findViewById(R.id.showName_textView)
    val ShowPoster: ImageView = itemView.findViewById(R.id.ShowPoster)

    fun setTVShowID(tvShowId: TvShowIdResponse){
        Glide.with(ShowPoster.context).load("https://image.tmdb.org/t/p/w500" + tvShowId.poster_path).into(ShowPoster)

    }

}