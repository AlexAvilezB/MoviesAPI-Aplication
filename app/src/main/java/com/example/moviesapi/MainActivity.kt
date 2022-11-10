package com.example.moviesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

        setTheme(R.style.Theme_MoviesAPI)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()


        Api.retrofitService.getTvShows().enqueue(
            object: Callback<TopRatedResponse> {
                override fun onResponse(call: Call<TopRatedResponse>, response: Response<TopRatedResponse>) {
                    Log.i("Retrofit", response.body().toString())

                    response.body()?.results?.let {
                        configureTvShowsList(it)
                    }
                }

                override fun onFailure(call: Call<TopRatedResponse>, t: Throwable) {
                    Log.i("Retrofit", t.message.toString())
                }
            }
        )
    }

    fun configureTvShowsList(data: List<TVShow>) {
        val adapter = TvShowAdapter(dataSet = data.toTypedArray()) { selectedId ->
            val miIntent = Intent(this, tvShowDetails::class.java)
            // Este parametro lo debe recuperar en la otra activity
            miIntent.putExtra("showId", selectedId)
            startActivity(miIntent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)
        val layoutManager = GridLayoutManager(this, 2)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}