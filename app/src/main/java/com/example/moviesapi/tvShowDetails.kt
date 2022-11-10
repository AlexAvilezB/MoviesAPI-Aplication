package com.example.moviesapi

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tvShowDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_details)

        val intent : Intent = getIntent()
        val show = intent.getIntExtra("showId", 0)

        Constants.SERIES_ID = show

    }

    override fun onResume() {
        super.onResume()


        ApiByID.retrofitService.getTvShowsByID().enqueue(
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
        }
    }

}
