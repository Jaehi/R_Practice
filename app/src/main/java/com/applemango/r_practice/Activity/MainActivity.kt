package com.applemango.r_practice.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.applemango.r_practice.Data.BoxOffice.MovieResponse
import com.applemango.r_practice.Data.BoxOffice.m_MovieDTO
import com.applemango.r_practice.Adapter.MainAdapter
import com.applemango.r_practice.R
import com.applemango.r_practice.Utils.BoxOffice.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var mAdapter: MainAdapter
    val items = listOf<m_MovieDTO>()
    val KEY = "b18e23af64d1ac84e0f918a093fa331e"

    private inline fun <T> Call<T>.enqueue(crossinline function: (body: T) -> Unit) {
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.body() == null)
                else
                    function(response.body()!!)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {

            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val date: Calendar = Calendar.getInstance()
        date.add(Calendar.DAY_OF_MONTH, -1)
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val targetDt = dateFormat.format(date.time)
        val mrecycler = findViewById<RecyclerView>(R.id.recycler_main)
        val intent = Intent(this, ResultActivity::class.java)
        var count: Int = 0

        mAdapter = MainAdapter(this, MainAdapter::class.java)
        mrecycler.adapter = mAdapter

        RetrofitBuilder.api
                .getMovieList(KEY, targetDt)
                .enqueue { body: MovieResponse ->
                    val movieResult: List<m_MovieDTO> = body.boxofficeResult!!.dailyBoxOfficeList

                    items.apply {
                        mAdapter.itemlist = movieResult
                        mAdapter.notifyDataSetChanged()
                    }

                    mAdapter.setOnItemClickListener(object : MainAdapter.OnItemClickListener {
                        override fun onItemClick(v: View, data: m_MovieDTO, pos: Int) {
                            intent.putExtra("moviename", movieResult.get(pos).movieNm)
                            startActivity(intent)

                        }

                    })
                }
    }
}