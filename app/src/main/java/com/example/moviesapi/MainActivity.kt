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
            object: Callback<List<TvShow>> {
                override fun onResponse(call: Call<List<TvShow>>, response: Response<List<TvShow>>) {
                    Log.i("Retrofit", response.body().toString())

                    response.body()?.let {
                        configureTvShowsList(it)
                    }
                }

                override fun onFailure(call: Call<List<TvShow>>, t: Throwable) {
                    Log.i("Retrofit", t.message.toString())
                }
            }
        )
    }

    fun configureTvShowsList(data: List<TvShow>) {
        val adapter = TvShowAdapter(dataSet = data.toTypedArray())

        val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)

        recyclerView.adapter = adapter
    }
}