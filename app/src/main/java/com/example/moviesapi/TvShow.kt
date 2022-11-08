package com.example.moviesapi

import com.squareup.moshi.Json

data class TopRatedResponse (
    val page: Long,
    val total_pages: Long,
    val total_results: Long,
    val results: List<TVShow>)

data class TVShow (
    val id: Int,
    val name: String,
    val first_air_date: String
)