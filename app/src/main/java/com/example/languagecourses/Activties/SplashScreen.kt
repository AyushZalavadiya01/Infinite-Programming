package com.example.languagecourses.Activties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.languagecourses.R

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val backgroundImage: ImageView = findViewById(R.id.splashImage)
        val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        backgroundImage.startAnimation(animationZoomIn)

        val firstText: TextView = findViewById(R.id.textView)
        val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        firstText.startAnimation(animationZoomOut)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

}