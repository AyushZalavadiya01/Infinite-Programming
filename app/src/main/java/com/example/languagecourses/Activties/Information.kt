package com.example.languagecourses.Activties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.languagecourses.R
import com.example.languagecourses.databinding.ActivityInformationBinding

class information : AppCompatActivity() {
    lateinit var binding : ActivityInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inf = findViewById<ImageView>(R.id.next1)
        inf.setOnClickListener {
            val intent = Intent(this, information2::class.java)
            startActivity(intent)
        }

        val skip = findViewById<TextView>(R.id.skip)
        skip.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}