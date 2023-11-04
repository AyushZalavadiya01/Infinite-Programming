package com.example.languagecourses.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecourses.R
import com.example.languagecourses.model.CourseModule

class SavedModulesAdapter(private val modules: List<CourseModule>) :
    RecyclerView.Adapter<SavedModulesAdapter.ModuleViewHolder>() {

    class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val moduleName: TextView = itemView.findViewById(R.id.moduleNameTextView)
//        val moduleDescription: TextView = itemView.findViewById(R.id.moduleDescriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.saved_module_item, parent, false)
        return ModuleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = modules[position]
        holder.moduleName.text = module.name
//        holder.moduleDescription.text = module.description
    }

    override fun getItemCount(): Int {
        return modules.size
    }
}