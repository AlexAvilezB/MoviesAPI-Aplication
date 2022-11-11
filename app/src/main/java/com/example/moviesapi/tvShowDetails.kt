package com.example.moviesapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tvShowDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_details)

        val intent : Intent = getIntent()
        val show = intent.getIntExtra("showId", 0)

        variable.serie_id = show

    }

    override fun onResume() {
        super.onResume()

        Api.retrofitService.getTvShowsByID(variable.serie_id).enqueue(
            object: Callback<TvShowIdResponse> {
                override fun onResponse(call: Call<TvShowIdResponse>, response: Response<TvShowIdResponse>) {
                    Log.i("Retrofit", response.body().toString())

                    response.body()?.let {
                        configureTvShow(it)
                    }

                }

                override fun onFailure(call: Call<TvShowIdResponse>, t: Throwable) {
                    Log.i("Retrofit", t.message.toString())
                }
            }
        )
    }

    fun configureTvShow(data: TvShowIdResponse) {
        val adapter = TvShowIDAdapter(dataSet = data)

        val recyclerView: RecyclerView = findViewById(R.id.tvShows_recycler_view)

        recyclerView.adapter = adapter
    }

}
