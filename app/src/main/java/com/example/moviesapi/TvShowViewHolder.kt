package com.example.moviesapi

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TvShowViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
    val firstAirTextView: TextView = itemView.findViewById(R.id.firstEmision_textView)
}