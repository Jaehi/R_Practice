package com.applemango.r_practice.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.icu.number.NumberFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.applemango.r_practice.GlideApp
import com.applemango.r_practice.MyGlideApp
import com.applemango.r_practice.R
import com.applemango.r_practice.databinding.ActivityCrawlingResultBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class CrawlingResultActivity : AppCompatActivity() {

    private val binding : ActivityCrawlingResultBinding by lazy {
        ActivityCrawlingResultBinding.inflate(LayoutInflater.from(this))
    }

    private val viewModel : CrawlingResultViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieName = intent.getStringExtra("movieName")
        val moviePoseter = intent.getStringExtra("moviePoster")
        Log.d("checkData","$movieName , $moviePoseter")

        if (moviePoseter != null) {
            setPoster(moviePoseter)
        }

        if (movieName != null){
            viewModel.setMovieName(movieName)
        }

        initView(binding)

    }

    private fun initView(binding: ActivityCrawlingResultBinding){
        with(binding){
            setContentView(binding.root)
            viewmodel = viewModel
            lifecycleOwner = this@CrawlingResultActivity
        }
    }

    private fun setPoster(url : String){

        Log.d("dasfjsdfjkljkl;dfsjkldfas","${viewModel.posterUrl.value}")
        CoroutineScope(Dispatchers.Main).launch {
            GlideApp.with(this@CrawlingResultActivity).load(url).centerCrop().into(binding.crawMovieposter)
        }
    }

}