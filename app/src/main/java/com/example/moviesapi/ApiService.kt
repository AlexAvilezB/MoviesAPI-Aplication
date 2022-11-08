package com.example.moviesapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val BASE_URL = "https://api.themoviedb.org/3/" //url de la api que se consume

const val TOKEN = "b7660a4fd30a46bf2866abe66bdd5194"

//Instancia de moshi
//Se pasa un factory, es decir que toma el json y lo convierte a una clase kt
//con el meto build se inicializa
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Siempre que se quiere consumir una api se realiza esto
private val retrofit = Retrofit.Builder()
    //.addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("tv/top_rated?api_key=${TOKEN}")
    fun getTvShows(): Call<TopRatedResponse> // Devuelve una objeto con el detalle
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}