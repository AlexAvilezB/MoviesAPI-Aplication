package com.example.moviesapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val BASE_URL = "https://api.themoviedb.org/3/tv/top_rated?api_key=b7660a4fd30a46bf2866abe66bdd5194" //url de la api que se consume

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

    @GET("results")
    fun getTvShows(): Call<List<TvShow>>//Devuelve una lista de usuarios
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}