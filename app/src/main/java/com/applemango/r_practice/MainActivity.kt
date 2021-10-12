package com.applemango.r_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var mAdapter : MainAdapter
    val items = mutableListOf<MainItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mrecycler = findViewById<RecyclerView>(R.id.recycler_main)

        mAdapter = MainAdapter(this)
        mrecycler.adapter = mAdapter

        items.apply {
            add(MainItemData("d","d","d"))
            mAdapter.itemlist = items
            mAdapter.notifyDataSetChanged()
        }
    }


}