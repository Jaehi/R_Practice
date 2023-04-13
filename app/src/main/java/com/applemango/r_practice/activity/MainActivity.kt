package com.applemango.r_practice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.applemango.r_practice.adapter.MainAdapter
import com.applemango.r_practice.databinding.ActivityMainBinding
import com.applemango.r_practice.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }

    private val viewModel : MainViewModel by viewModels()

    private val adapter = MainAdapter{ data ->
        val title = data.movieNm
        val poster = viewModel.moviePoster[data.movieNm].toString()
        val story = viewModel.movieStory[data.movieNm].toString()

        startActivity(Intent(this,CrawlingResultActivity::class.java).apply {
            putExtra("movieName",title)
            putExtra("moviePoster",poster)
            putExtra("movieStory",story)
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startObserve()
        initView()
    }

    private fun initView() {
        with(binding){
            setContentView(binding.root)
            viewmodel = viewModel
            lifecycleOwner = this@MainActivity
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