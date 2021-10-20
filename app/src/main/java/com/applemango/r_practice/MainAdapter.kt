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

    var itemlist = listOf<m_MovieDTO>()
   // var poster = listOf<m_PosterDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_main, parent, false)
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

        fun bind(item: m_MovieDTO){
            moviename.text = item.movieNm.toString()
            moviewgenre.text = item.rank.toString()
           // Glide.with(itemView).load(url).into(moviewposter)
        }
    }

}