package com.example.languagecourses.Activties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.languagecourses.R
import com.example.languagecourses.databinding.ActivityInformation2Binding

class information2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding : ActivityInformation2Binding
        super.onCreate(savedInstanceState)
        binding = ActivityInformation2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val inf = findViewById<ImageView>(R.id.next2)
        inf.setOnClickListener {
            val intent = Intent(this, information3::class.java)
            startActivity(intent)
        }

        val skip = findViewById<TextView>(R.id.skip)
        skip.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}