package com.applemango.r_practice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.applemango.r_practice.adapter.MainAdapter
import com.applemango.r_practice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    private val viewModel : MainViewModel by viewModels()

    private val adapter = MainAdapter{
        val title = viewModel.moviewResult.keys.contains(it.movieNm).toString()
        val poster = viewModel.moviewResult[it.movieNm].toString()
        startActivity(Intent(this,CrawlingResultActivity::class.java).apply {
            putExtra("movieName",title)
            putExtra("moviePoster",poster)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        startObserve()
        initRecylcerView()

    }

    private fun initRecylcerView() {
        with(binding){
            recyclerMain.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerMain.adapter = adapter
        }
    }

    private fun startObserve(){
        viewModel.movieData.observe(this){
            adapter.setList(it)
        }
    }
}