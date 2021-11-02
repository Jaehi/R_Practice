package com.applemango.r_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultActivity : AppCompatActivity() {
    val clientID: String = "Z2nZiBjLroT1hESkr3iC"
    val clientSecret: String = "_q_7JEK2_A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val movieName = intent.getStringExtra("moviename")

        val ResultTitle = R.id.result_moviename
        val ResultDirector = R.id.result_moviedirector
        val ResultDate = R.id.result_moviedate

        val namefiled = findViewById<TextView>(R.id.result_moviename)

        namefiled.setText(movieName.toString())
    }

    override fun onStart() {
        val movieName = intent.getStringExtra("moviename")
        val image = findViewById<ImageView>(R.id.result_movieposter)
        super.onStart()
        NaverBuilder.p_api.getPoster(clientID, clientSecret, movieName).enqueue(object : Callback<NaverResult> {
            override fun onResponse(call: Call<NaverResult>, response: Response<NaverResult>) {
                val posterRespons = response.body()
                val resultList: List<m_NaverDTO> = posterRespons!!.posterresult


                Log.d("성공햇나?", "$resultList")

                    Glide.with(this@ResultActivity).load(resultList.get(0).image).into(image)


            }

            override fun onFailure(call: Call<NaverResult>, t: Throwable) {
                Log.d("실패했다", "실패햇다고")
            }

        })
    }
}