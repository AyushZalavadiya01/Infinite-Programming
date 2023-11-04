package com.example.languagecourses.fragment.BasicProgramming

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecourses.DataClass.Cprogramming
import com.example.languagecourses.Activties.Quiz
import com.example.languagecourses.R
import com.example.languagecourses.adapter.MyAdapter


class Python : Fragment() {


    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemlist : ArrayList<Cprogramming>

    lateinit var imageId:Array<Int>
    lateinit var heading : Array<String>
    lateinit var desc : Array<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_python, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val button = view.findViewById<TextView>(R.id.takeQuiz)

        button.setOnClickListener {
            // Create an intent to navigate to the target activity
            val intent = Intent(activity, Quiz::class.java)

            // Optionally, you can pass data to the activity using intent extras
            intent.putExtra("key", "value")

            // Start the target activity
            startActivity(intent)
        }

        dataInitialize()

        val layoutManager = LinearLayoutManager(view.context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(ArrayList(itemlist))
        recyclerView.adapter = adapter

    }

    private fun dataInitialize(){

        itemlist = arrayListOf<Cprogramming>()

        imageId = arrayOf(
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,

            )

        heading = arrayOf(


            getString(R.string.p_1),
            getString(R.string.p_2),
            getString(R.string.p_3),
            getString(R.string.p_4),
            getString(R.string.p_5),
            getString(R.string.p_6),
            getString(R.string.p_7),
            getString(R.string.p_8),
            getString(R.string.p_9),
            getString(R.string.p_10),
            getString(R.string.p_11),


            )
        desc= arrayOf(
            getString(R.string.pd_1),
            getString(R.string.pd_2),
            getString(R.string.pd_3),
            getString(R.string.pd_4),
            getString(R.string.pd_5),
            getString(R.string.pd_6),
            getString(R.string.pd_7),
            getString(R.string.pd_8),
            getString(R.string.pd_9),
            getString(R.string.pd_10),
            getString(R.string.pd_11)

        )



        for (i in imageId.indices){
            val cModule = Cprogramming(imageId[i],heading[i],desc[i])
            itemlist.add(cModule)
        }
    }

}