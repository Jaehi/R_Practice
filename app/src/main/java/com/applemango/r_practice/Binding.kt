package com.applemango.r_practice

import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import androidx.core.view.drawToBitmap
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL
import javax.net.ssl.HttpsURLConnection


@BindingAdapter("setImage")
fun setImage(view : View, posterUrl : String?){

    Log.d("fasdhjkhjkasdfjhkasdfidfashjkasdf","${posterUrl}")
    if (posterUrl != null){
        CoroutineScope(Dispatchers.Main).launch {
            val url = URL(posterUrl)
            val connection = url.openConnection() as HttpsURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            val bitmap = BitmapFactory.decodeStream(input)

            view.drawToBitmap(bitmap.config)
        }
    }
}