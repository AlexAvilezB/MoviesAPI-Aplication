package com.example.moviesapi

import com.squareup.moshi.Json

data class TvShow(
    val id: Int,
    val name: String,
    val first_air_date: String
)