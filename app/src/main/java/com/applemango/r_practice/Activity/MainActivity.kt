package com.applemango.r_practice.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applemango.r_practice.Data.BoxOffice.MovieResponse
import com.applemango.r_practice.Data.BoxOffice.m_MovieDTO
import com.applemango.r_practice.Adapter.MainAdapter
import com.applemango.r_practice.R
import com.applemango.r_practice.Utils.BoxOffice.RetrofitBuilder
import com.applemango.r_practice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
//    private val viewModel : MainViewModel by viewModels()
    private val adapter = MainAdapter{
        startActivity(Intent(this,ResultActivity::class.java).apply {
            putExtra("moviename",it)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecylcerView()
    }

    private fun initRecylcerView() {
        with(binding){
            recyclerMain.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerMain.adapter = adapter
        }
    }
}