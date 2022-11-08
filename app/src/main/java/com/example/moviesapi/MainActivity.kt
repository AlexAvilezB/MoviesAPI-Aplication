package com.example.moviesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
        val adapter = TvShowAdapter(dataSet = data.toTypedArray())

        val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)

        recyclerView.adapter = adapter
    }
}