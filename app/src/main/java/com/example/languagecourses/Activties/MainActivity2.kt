package com.example.languagecourses.Activties

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.languagecourses.Profile
import com.example.languagecourses.R
import com.example.languagecourses.Saved
import com.example.languagecourses.databinding.ActivityMain2Binding
import com.example.languagecourses.fragment.Certificate
import com.example.languagecourses.fragment.home

class MainActivity2 : AppCompatActivity() {


    lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation=(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(home())



        binding.bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId){

                R.id.home -> replaceFragment(home())
                R.id.save -> replaceFragment(Saved())
//                R.id.cert -> replaceFragment(Certificate())
                R.id.profile -> replaceFragment(Profile())

                else ->{

                }
            }
            true
        }

    }


    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout_1,fragment)
        fragmentTransaction.commit()

    }

}