package com.applemango.r_practice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.applemango.r_practice.GlideApp
import com.applemango.r_practice.databinding.ActivityCrawlingResultBinding
import com.applemango.r_practice.viewmodel.CrawlingResultViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrawlingResultActivity : AppCompatActivity() {

    private val bind : ActivityCrawlingResultBinding by lazy {
        ActivityCrawlingResultBinding.inflate(LayoutInflater.from(this))
    }

    private val viewModel : CrawlingResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieName = intent.getStringExtra("movieName")
        val moviePoseter = intent.getStringExtra("moviePoster")
        val movieStory = intent.getStringExtra("movieStory")

        Log.d("checkData","$movieName , $moviePoseter , $movieStory")

        if (moviePoseter != null) {
            setPoster(moviePoseter)
        }

        if (movieName != null){
            viewModel.setMovieName(movieName)
        }

        if (movieStory != null){
            viewModel.setMovieStory(movieStory)
        }

        viewModel.getMovieData()
        initView(bind)

    }

    private fun initView(binding: ActivityCrawlingResultBinding){
        with(binding){
            setContentView(binding.root)
            viewmodel = viewModel
            lifecycleOwner = this@CrawlingResultActivity
        }
    }

    private fun setPoster(url : String){
        CoroutineScope(Dispatchers.Main).launch {
            GlideApp.with(this@CrawlingResultActivity).load(url).centerCrop().into(bind.crawMovieposter)
        }
    }

}