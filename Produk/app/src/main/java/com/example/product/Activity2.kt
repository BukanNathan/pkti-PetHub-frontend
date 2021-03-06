package com.example.product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val back = findViewById<ImageButton>(R.id.imageBack)
        back.setOnClickListener {
            val intentback = Intent(this, Activity::class.java)
            startActivity(intentback)
        }

        val button = findViewById<ImageButton>(R.id.right_icon)
        button.setOnClickListener{
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }
    }
}