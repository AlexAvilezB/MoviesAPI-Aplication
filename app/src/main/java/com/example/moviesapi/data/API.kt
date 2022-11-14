package com.example.moviesapi.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://api.themoviedb.org/3/"

const val API_KEY = "b7660a4fd30a46bf2866abe66bdd5194"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("tv/top_rated?api_key=${API_KEY}")
    fun getTvShows(): Call<TopRatedResponse>

    @GET("tv/{showId}?api_key=${API_KEY}")
    fun getTvShowsByID(
        @Path("showId") showId: Int): Call<ShowDetailResponse>

}

object Api {

    val service : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}