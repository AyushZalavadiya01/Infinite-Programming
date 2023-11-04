package com.example.languagecourses.fragment

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.languagecourses.R
import com.example.languagecourses.Utils.SavedModuleStore
import com.example.languagecourses.databinding.FragmentBasicProgrammingBinding
import com.example.languagecourses.fragment.BasicProgramming.C_Plus
import com.example.languagecourses.fragment.BasicProgramming.C_Programming
import com.example.languagecourses.fragment.BasicProgramming.C_Sharp
import com.example.languagecourses.fragment.BasicProgramming.Java
import com.example.languagecourses.fragment.BasicProgramming.Python
import com.example.languagecourses.model.CourseModule


class Basic_Programming : Fragment() {


    private  val binding by lazy {
        FragmentBasicProgrammingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //activity?.requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT



        //saved event for basic programming
        binding.saveCprogramming.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("C Programming")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "C Programming module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveCc.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("C++ Programming")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "C++ Programming module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.savePython.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Python Programming")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "Python Programming module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveJava.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("Java Programming")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "Java Programming module saved!", Toast.LENGTH_SHORT).show()
        }

        binding.saveCsharp.setOnClickListener {
            // Create a CourseModule object and add it to the list of saved modules
            val savedModules = SavedModuleStore.savedModules
            val cProgrammingModule = CourseModule("C Sharp Programming")
            savedModules.add(cProgrammingModule)
            Toast.makeText(requireContext(), "C Sharp Programming module saved!", Toast.LENGTH_SHORT).show()
        }




        //fragment transaction

            binding.cp.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, C_Programming())
          //  transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)
            transaction?.commit()
       }

//            findNavController().navigate(requireActivity(),Bundle().apply {

 //           })

        binding.cc.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, C_Plus())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)

            transaction?.commit()
        }

        binding.python1.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, Python())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)

            transaction?.commit()
        }

        binding.java1.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, Java())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)

            transaction?.commit()
        }

        binding.csharp1.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout_1, C_Sharp())
//            transaction?.disallowAddToBackStack()
            transaction?.addToBackStack(null)

            transaction?.commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root


    }

}