package com.example.languagecourses

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecourses.Utils.SavedModuleStore
import com.example.languagecourses.adapter.SavedModulesAdapter
import com.example.languagecourses.model.CourseModule


class Saved : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val savedModules: List<CourseModule> = SavedModuleStore.savedModules
        Log.d("SavedFragment", "Saved Modules: $savedModules")


        val recyclerView: RecyclerView = view.findViewById(R.id.savedModulesRecyclerView)

        // Create an adapter to display the saved modules in the RecyclerView
        val adapter = SavedModulesAdapter(SavedModuleStore.savedModules)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }
}