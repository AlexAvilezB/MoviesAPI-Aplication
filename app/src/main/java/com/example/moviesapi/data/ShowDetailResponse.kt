package com.example.moviesapi.data

import com.squareup.moshi.Json

data class ShowDetailResponse (
    val name: String,

    @Json(name = "backdrop_path")
    val backdrop: String? = null,

    @Json(name = "poster_path")
    val poster: String,

    @Json(name = "number_of_episodes")
    val episodesCount: Int,

    @Json(name = "number_of_seasons")
    val seasonsCount: Int,

    val overview: String,
    val genres: List<Categories>
)

data class Categories (
    val name: String,
    val id: Int,
)

fun ShowDetailResponse.getBackDropURL(): String {
    return "https://image.tmdb.org/t/p/w500$backdrop"
}

fun ShowDetailResponse.getPosterURL(): String {
    return "https://image.tmdb.org/t/p/w500$poster"
}