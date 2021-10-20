package com.applemango.r_practice

import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdapter : MainAdapter
    val items = listOf<m_MovieDTO>()
    val KEY = "b18e23af64d1ac84e0f918a093fa331e"
    val clientID : String = "Z2nZiBjLroT1hESkr3iC"
    val clientSecret : String = "_q_7JEK2_A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val date: Calendar = Calendar.getInstance()
        date.add(Calendar.DAY_OF_MONTH, -1)
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val targetDt = dateFormat.format(date.time)
        val mrecycler = findViewById<RecyclerView>(R.id.recycler_main)

        mAdapter = MainAdapter(this)
        mrecycler.adapter = mAdapter


        RetrofitBuilder.api
                .getMovieList(KEY,targetDt)
                .enqueue(object :  Callback<MovieResponse> {
                    override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                        val MovieResponse = response.body()
                        val movieList : List<m_MovieDTO> = MovieResponse!!.boxofficeResult!!.dailyBoxOfficeList
                        Log.d("eeeeee","$movieList")
                        items.apply {
                            mAdapter.itemlist = movieList
                            mAdapter.notifyDataSetChanged()
                        }
                        for (i : Int in 0..movieList.size-1){
                            MoviePosterBuilder.p_api
                                    .getPoster(clientID,clientSecret,movieList.get(i).movieNm)
                                    .enqueue(object : Callback<PosterResult>{
                                        override fun onResponse(call: Call<PosterResult>, response: Response<PosterResult>) {
                                            val PosterResponse = response.body()
                                            val posterList : List<m_PosterDTO> = PosterResponse!!.posterresult
                                            Log.d("00000000000","$posterList")
                                        }

                                        override fun onFailure(call: Call<PosterResult>, t: Throwable) {
                                            TODO("Not yet implemented")
                                        }

                                    })
                        }
                    }
                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d("fffffffff","fail")}

                })





    }


}