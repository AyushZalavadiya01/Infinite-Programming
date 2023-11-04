package com.example.languagecourses.fragment.BasicProgramming

//import com.example.languagecourses.adapter.CustomListAdapter
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

class C_Programming : Fragment() {


    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemlist: ArrayList<Cprogramming>

    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var desc: Array<String>
//    lateinit var videoUrl: Array<String>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    @Suppress("UNREACHABLE_CODE")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c__programming, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.cQuiz.setOnClickListener {
//            val activity: FragmentActivity? = activity
//            activity?.finish()

//        }




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

            )

        heading = arrayOf(

            getString(R.string.c_1),
            getString(R.string.c_2),
            getString(R.string.c_3),
            getString(R.string.c_4),
            getString(R.string.c_5),
            getString(R.string.c_6),
            getString(R.string.c_7),
            getString(R.string.c_8),
            getString(R.string.c_9),
            getString(R.string.c_10),

            )
        desc = arrayOf(
            getString(R.string.c_d_1),
            getString(R.string.c_d_2),
            getString(R.string.c_d_3),
            getString(R.string.c_d_4),
            getString(R.string.c_d_5),
            getString(R.string.c_d_6),
            getString(R.string.c_d_7),
            getString(R.string.c_d_8),
            getString(R.string.c_d_9),
            getString(R.string.c_d_10),

        )

//        videoUrl = arrayOf(
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//            "https://www.youtube.com/watch?v=viHILXVY_eU",
//        )


        for (i in imageId.indices) {
            val cModule = Cprogramming(imageId[i], heading[i], desc[i])

            itemlist.add(cModule)
        }
    }


}