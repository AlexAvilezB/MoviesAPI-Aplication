package com.example.moviesapi

import com.squareup.moshi.Json

data class TvShows (
    val page: Long,
    val total_pages: Long,
    val total_results: Long,
    val results: List<TvShow>
        )

data class TvShow (
    val id: Int,
    val name: String,
    val first_air_date: String
)