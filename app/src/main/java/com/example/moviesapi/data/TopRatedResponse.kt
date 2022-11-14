package com.example.moviesapi.data

import com.squareup.moshi.Json

data class TopRatedResponse (
    val page: Long,
    val results: List<TVShow>)

data class TVShow (
    val id: Int,
    val name: String,

    @Json(name="poster_path")
    val poster: String
)

fun TVShow.getPosterURL(): String {
    return "https://image.tmdb.org/t/p/w500$poster"
}