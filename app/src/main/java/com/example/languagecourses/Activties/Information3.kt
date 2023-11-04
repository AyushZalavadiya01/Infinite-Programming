package com.example.languagecourses.Activties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.languagecourses.R
import com.example.languagecourses.databinding.ActivityInformation3Binding

class information3 : AppCompatActivity() {
    lateinit var binding : ActivityInformation3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformation3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainAct2 = findViewById<ImageView>(R.id.next3)
        mainAct2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val skip = findViewById<TextView>(R.id.skip)
        skip.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}