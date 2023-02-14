package com.applemango.r_practice.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.applemango.r_practice.activity.ResultActivity
import com.applemango.r_practice.data.boxOffice.m_MovieDTO
import com.applemango.r_practice.R
import com.applemango.r_practice.activity.CrawlingResultActivity

class MainAdapter(val onClick : (m_MovieDTO) -> Unit ) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    lateinit var context : Context
    private var itemlist = listOf<m_MovieDTO>()


    fun setList(data : List<m_MovieDTO>){
        itemlist = data
        Log.d("!!!!!!!!!!!!!!!!!!!","${itemlist}")
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

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

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val moviename: TextView = itemView.findViewById(R.id.movie_name)
        private val moviewgenre: TextView = itemView.findViewById(R.id.movie_rank)


        fun bind(item: m_MovieDTO) {
            moviename.text = item.movieNm.toString()
            moviewgenre.text = item.rank.toString()
            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }

}