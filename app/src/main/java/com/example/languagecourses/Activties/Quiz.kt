package com.example.languagecourses.Activties

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.languagecourses.adapter.QuizAdapter
import com.example.languagecourses.databinding.ActivityQuizBinding
import com.example.languagecourses.model.Question
import com.example.languagecourses.model.Quizz
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.Date

class Quiz : AppCompatActivity() {



//   val questions: MutableMap<String, Question>? = null



    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quizz>()
    private lateinit var firestore: FirebaseFirestore

    lateinit var binding : ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        //populateDammydata()

        adapter = QuizAdapter(this, quizList)
        binding.quizRecyclerView.layoutManager=GridLayoutManager(this,2,GridLayoutManager.VERTICAL,
            false)
        binding.quizRecyclerView.setHasFixedSize(true)
        binding.quizRecyclerView.adapter=adapter

        setUpFireStore()
//        setUpRecyclerView()
        setUpDatePicker()

//        setUpViews()
    }


//    private fun setUpViews() {
//
//        setUpFireStore()
////        setUpRecyclerView()
//        setUpDatePicker()
//
//    }

    private fun setUpDatePicker() {
        binding.btnDatePicker.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "DatePicker")
            datePicker.addOnPositiveButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)
                val dateFormatter = SimpleDateFormat("dd-mm-yyyy")
                val date = dateFormatter.format(Date(it))
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("DATE", date)
                startActivity(intent)
            }
            datePicker.addOnNegativeButtonClickListener {
                Log.d("DATEPICKER", datePicker.headerText)
            }
            datePicker.addOnCancelListener {
                Log.d("DATEPICKER", "Date Picker Cancelled")
            }
        }
    }

        private fun setUpFireStore() {
        firestore = FirebaseFirestore.getInstance()
        val collectionReference = firestore.collection("quizzes")

        collectionReference.addSnapshotListener { value, error ->

            if(value == null || error != null){
                Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            Log.d("DATA", value.toObjects(Quizz::class.java).toString())
            quizList.clear()
            quizList.addAll(value.toObjects(Quizz::class.java))
            adapter.notifyDataSetChanged()
        }
    }

//    private fun setUpRecyclerView() {
//        adapter = QuizAdapter(this, quizList)
//        binding.quizRecyclerView.setHasFixedSize(true)
//        binding.quizRecyclerView.layoutManager=GridLayoutManager(this,2)
//        binding.quizRecyclerView.adapter=adapter
//
//
//    }


}