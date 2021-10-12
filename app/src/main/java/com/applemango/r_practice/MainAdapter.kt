package com.applemango.r_practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(private val context: Context):RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var itemlist = mutableListOf<MainItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_main,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemlist[position])
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val moviename : TextView = itemView.findViewById(R.id.movie_name)
        private val moviewgenre : TextView = itemView.findViewById(R.id.movie_genre)
        private val moviewposter : ImageView = itemView.findViewById(R.id.movie_poster)

        fun bind(item : MainItemData){
            moviename.text = item.movieName
            moviewgenre.text = item.movieGenre
            Glide.with(itemView).load(item.moviePoster).into(moviewposter)
        }
    }

}