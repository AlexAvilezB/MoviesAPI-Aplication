package com.example.moviesapi.showsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapi.showDetail.ShowDetailActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.moviesapi.R
import com.example.moviesapi.data.Api
import com.example.moviesapi.data.TVShow
import com.example.moviesapi.data.TopRatedResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_MoviesAPI)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        Api.service.getTvShows().enqueue(
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
        val adapter = ShowsListAdapter(dataSet = data.toTypedArray()) { selectedId ->

            val miIntent = Intent(this, ShowDetailActivity::class.java)
            miIntent.putExtra("showId", selectedId)
            startActivity(miIntent)
        }

        val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)
        val layoutManager = GridLayoutManager(this, 2)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}