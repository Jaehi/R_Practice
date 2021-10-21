package com.applemango.r_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val clientID: String = "Z2nZiBjLroT1hESkr3iC"
        val clientSecret: String = "_q_7JEK2_A"
        val movieName = intent.getStringExtra("moviename")

        val namefiled = findViewById<TextView>(R.id.result_moviename)

        namefiled.setText(movieName.toString())
    }
}