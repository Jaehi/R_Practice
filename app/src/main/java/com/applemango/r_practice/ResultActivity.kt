package com.applemango.r_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val clientID: String = "Z2nZiBjLroT1hESkr3iC"
        val clientSecret: String = "_q_7JEK2_A"
        val movieName = intent.getStringExtra("moviename")

        val ResultTitle = R.id.result_moviename
        val ResultDirector = R.id.result_moviedirector
        val ResultDate = R.id.result_moviedate
        val image = findViewById<ImageView>(R.id.result_movieposter)

        val namefiled = findViewById<TextView>(R.id.result_moviename)


        NaverBuilder.p_api.getPoster(clientID,clientSecret,movieName).enqueue(object : Callback<NaverResult>{
            override fun onResponse(call: Call<NaverResult>, response: Response<NaverResult>) {
                val posterRespons  = response.body()
                val resultList : List<m_NaverDTO> = posterRespons!!.posterresult
                Log.d("성공햇나?","$resultList")


            }

            override fun onFailure(call: Call<NaverResult>, t: Throwable) {
                Log.d("실패했다","실패햇다고")
            }

        })

        namefiled.setText(movieName.toString())
    }
}