package com.example.moviesapi.showDetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapi.R
import com.example.moviesapi.data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowDetailActivity : AppCompatActivity() {

    var showId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_details)

        val intent : Intent = getIntent()

        showId = intent.getIntExtra("showId", 0)
    }

    override fun onResume() {
        super.onResume()

        Api.service.getTvShowsByID(showId).enqueue(
            object: Callback<ShowDetailResponse> {

                override fun onResponse(call: Call<ShowDetailResponse>, response: Response<ShowDetailResponse>) {
                    Log.i("Retrofit", response.body().toString())

                    response.body()?.let {
                        configureTvShow(it)
                    }
                }

                override fun onFailure(call: Call<ShowDetailResponse>, t: Throwable) {
                    Log.i("Retrofit", t.message.toString())
                }
            }
        )
    }

    fun configureTvShow(data: ShowDetailResponse) {
        val adapter = ShowDetailAdapter(dataSet = data)

        val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)

        recyclerView.adapter = adapter
    }
}
