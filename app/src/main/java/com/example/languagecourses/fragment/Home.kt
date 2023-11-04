package com.example.languagecourses.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.languagecourses.R
import com.example.languagecourses.Utils.SavedModuleStore
import com.example.languagecourses.databinding.FragmentHomeBinding
import com.example.languagecourses.model.CourseModule

class home : Fragment() {


private  val binding by lazy {
    FragmentHomeBinding.inflate(layoutInflater)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.saveBasicPro.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Basic Programming")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "Basic Programming module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveweb.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Web Technology")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "Web Technology module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveAi.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Ai / Ml Course")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "Ai / Ml module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveDsa.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Data Structures And Algorithms")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "DSA module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveAndroid.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Android Application Development")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "Android Development module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveFlutter.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Flutter Application Development")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "Flutter Development module saved!", Toast.LENGTH_SHORT).show()
        }





        // Basic Programming
        binding.module1.setOnClickListener {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.frameLayout_1, Basic_Programming())
//        transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)
        transaction?.commit()
       }

        //Web Technology
        binding.module2.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, WebTechnology())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        //AI/ML
        binding.module3.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, Ai_Ml())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)
            transaction?.commit()

        }
        //Dsa
        binding.module4.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, Dsa())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
            // Android Application
        binding.module5.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, AndroidAppDev())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
            // Flutter Application
        binding.module6.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, FlutterAppDev())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)
            transaction?.commit()
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }
}