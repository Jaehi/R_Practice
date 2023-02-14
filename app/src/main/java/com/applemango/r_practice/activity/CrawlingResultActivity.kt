package com.applemango.r_practice.activity

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.applemango.r_practice.R
import com.bumptech.glide.Glide
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

class CrawlingResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crawling_result)

        intent.extras
        val movieName = intent.getStringExtra("movieName")
        val moviePoseter = intent.getStringExtra("moviePoster")

        Log.d("sidkdkdkkdkdkkdkdkdkd","$movieName , $moviePoseter")

        val nameArea = findViewById<TextView>(R.id.craw_moviename)

        nameArea.setText(movieName)

        if (moviePoseter != null) {
            setPoster(moviePoseter)
        }
    }

    private fun setPoster(url : String){

        val posterArea = findViewById<ImageView>(R.id.craw_movieposter)
        Log.d("sadadsjklfsdjkljklasdfjkldfs","$url")
        CoroutineScope(Dispatchers.Main).launch {
            Glide.with(this@CrawlingResultActivity).asBitmap().load(url).centerCrop().diskCacheStrategy(
                DiskCacheStrategy.RESOURCE).into(posterArea)
        }
    }
}