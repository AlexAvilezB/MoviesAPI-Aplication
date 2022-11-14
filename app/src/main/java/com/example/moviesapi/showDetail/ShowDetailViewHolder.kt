package com.example.moviesapi.showDetail

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapi.R
import com.example.moviesapi.data.*
import com.example.moviesapi.helpers.setImage

class ShowDetailViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.showName_textView)
    private val posterImageView: ImageView = itemView.findViewById(R.id.ShowPoster)
    private val backDropImageView: ImageView = itemView.findViewById(R.id.series_backdrop)
    private val episodesTextView: TextView = itemView.findViewById(R.id.showEpisodes_textView)
    private val seasonsTextView: TextView = itemView.findViewById((R.id.showSeasons_textView))
    private val overviewTextView: TextView = itemView.findViewById(R.id.overview_textView)
    private val categoriesTextView: TextView = itemView.findViewById(R.id.Categories_textView)

    fun setTVShow(item: ShowDetailResponse) {
        nameTextView.text = item.name
        episodesTextView.text = item.episodesCount.toString()
        overviewTextView.text = item.overview
        seasonsTextView.text = item.seasonsCount.toString()

        var genre = ""

        for (Categories in item.genres) {
            genre += Categories.name + ", "
        }

        categoriesTextView.text = genre.dropLast(2)

        posterImageView.setImage(item.getPosterURL())
        backDropImageView.setImage(item.getBackDropURL())
    }
}