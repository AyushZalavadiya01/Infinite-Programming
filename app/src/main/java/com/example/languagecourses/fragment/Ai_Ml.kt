package com.example.languagecourses.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecourses.Activties.Quiz
import com.example.languagecourses.DataClass.Cprogramming
import com.example.languagecourses.R
import com.example.languagecourses.adapter.MyAdapter


class Ai_Ml : Fragment() {

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemlist: ArrayList<Cprogramming>

    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var desc: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ai_ml, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val button = view.findViewById<TextView>(R.id.takeQuiz)
        button.setOnClickListener {
            val intent = Intent(activity, Quiz::class.java)
            intent.putExtra("key", "value")
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

    private fun dataInitialize() {

        itemlist = arrayListOf<Cprogramming>()

        imageId = arrayOf(

            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,


            )

        heading = arrayOf(

            getString(R.string.ai_1),
            getString(R.string.ai_2),
            getString(R.string.ai_3),
            getString(R.string.ai_4),
            getString(R.string.ai_5),
            getString(R.string.ai_6)


            )
        desc = arrayOf(
            getString(R.string.aid_1),
            getString(R.string.aid_2),
            getString(R.string.aid_3),
            getString(R.string.aid_4),
            getString(R.string.aid_5),
            getString(R.string.aid_6)

        )



        for (i in imageId.indices) {
            val cModule = Cprogramming(imageId[i], heading[i], desc[i])

            itemlist.add(cModule)
        }
    }
}