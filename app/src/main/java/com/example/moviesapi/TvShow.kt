package com.example.moviesapi

import com.squareup.moshi.Json

data class TvShowIdResponse (
    val name: String,
    val backdrop_path: String,
    val poster_path: String,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val genres: List<Categories>
)

data class Categories (
    val name: String,
    val id: Int,
)

data class TopRatedResponse (
    val page: Long,
    val total_pages: Long,
    val total_results: Long,
    val results: List<TVShow>)

data class TVShow (
    val id: Int,
    val name: String,
    val first_air_date: String,
    val poster_path: String
)
