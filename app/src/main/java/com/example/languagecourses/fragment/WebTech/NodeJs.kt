package com.example.languagecourses.fragment.WebTech

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecourses.Activties.Quiz
import com.example.languagecourses.DataClass.Cprogramming
import com.example.languagecourses.R
import com.example.languagecourses.adapter.MyAdapter


class NodeJs : Fragment() {
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemlist : ArrayList<Cprogramming>

    lateinit var imageId:Array<Int>
    lateinit var heading : Array<String>
    lateinit var desc : Array<String>
//    lateinit var videoUrl : Array<String>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_node_js, container, false)
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
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,
            R.drawable.folder,

            )

        heading = arrayOf(


            getString(R.string.nj_1),
            getString(R.string.nj_2),
            getString(R.string.nj_3),
            getString(R.string.nj_4),
            getString(R.string.nj_5),
            getString(R.string.nj_6),
            getString(R.string.nj_7),
            getString(R.string.nj_8),
            getString(R.string.nj_9),
            getString(R.string.nj_10),
            getString(R.string.nj_11),
            getString(R.string.nj_12),



            )
        desc= arrayOf(
            getString(R.string.n_jd1),
            getString(R.string.n_jd2),
            getString(R.string.n_jd3),
            getString(R.string.n_jd4),
            getString(R.string.n_jd5),
            getString(R.string.n_jd6),
            getString(R.string.n_jd7),
            getString(R.string.n_jd8),
            getString(R.string.n_jd9),
            getString(R.string.n_jd10),
            getString(R.string.n_jd11),
            getString(R.string.n_jd12)
        )



        for (i in imageId.indices) {
            val cModule = Cprogramming(imageId[i], heading[i],desc[i])
            itemlist.add(cModule)
        }
    }


}