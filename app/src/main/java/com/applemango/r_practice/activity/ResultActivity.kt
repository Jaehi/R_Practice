package com.applemango.r_practice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.applemango.r_practice.data.naver.NaverResult
import com.applemango.r_practice.data.naver.m_NaverDTO
import com.applemango.r_practice.utils.Naver.NaverBuilder
import com.applemango.r_practice.R
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultActivity : AppCompatActivity() {
    private val clientID: String = "Z2nZiBjLroT1hESkr3iC"
    private val clientSecret: String = "_q_7JEK2_A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieName = intent.getStringExtra("moviename")
        setContentView(R.layout.activity_result)
        val movieActor = findViewById<TextView>(R.id.result_moviedirector)
        val rating = findViewById<RatingBar>(R.id.rating)
        val image = findViewById<ImageView>(R.id.result_movieposter)
        val namefiled = findViewById<TextView>(R.id.result_moviename)

        namefiled.text = movieName.toString()

        namefiled.setText(movieName.toString())

        NaverBuilder.p_api.getPoster(clientID, clientSecret, movieName).enqueue(object : Callback<NaverResult> {

            override fun onResponse(call: Call<NaverResult>, response: Response<NaverResult>) {
                val posterRespons = response.body()
                val resultList: List<m_NaverDTO> = posterRespons!!.posterresult
                val ratingresult = (resultList[0].rating) / 2
                val actor = getActor(resultList[0].actor)
                Log.d("S", "$resultList")
                Log.d("S", "$actor")

                Glide.with(this@ResultActivity).load(resultList[0].image).into(image)
                rating.rating = ratingresult

                for (i in actor.indices){
                    movieActor.append(actor[i] + " ")
                }

            }

            override fun onFailure(call: Call<NaverResult>, t: Throwable) {
                Log.d("F", "$t")
            }

        })
    }


    fun getActor(data :String):List<String>{
        val datalist = data.split("|")
        return datalist

    }

}
