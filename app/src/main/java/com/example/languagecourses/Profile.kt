package com.example.languagecourses


import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.languagecourses.databinding.FragmentBasicProgrammingBinding
import com.example.languagecourses.databinding.FragmentProfileBinding
import com.example.languagecourses.model.User


import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.firestore.FirebaseFirestore


class Profile : Fragment() {

    private  val binding by lazy {
        FragmentProfileBinding.inflate(layoutInflater)
    }

    private lateinit var auth: FirebaseAuth
    private lateinit var db:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)
//
//
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = binding.root
        val currentUser = auth.currentUser

        if (currentUser != null) {

            db.collection("USER")
                .whereEqualTo("Email", currentUser.email)
                .get()
                .addOnSuccessListener { documents ->
                    if (!documents.isEmpty) {
                        // Assuming there's only one matching document
                        val user = documents.documents[0].toObject(User::class.java)

                        // Now, you have the user data, and you can update your UI
                        binding.txtEmail.text = currentUser.email
                        binding.txtName.text = user?.name
                        binding.txtPhone.text = user?.phone

                    }
                }
                .addOnFailureListener { e ->

                    Log.e("FirestoreError", "Error fetching user data: $e")
                }
        }

//        return inflater.inflate(R.layout.fragment_profile, container, false)
        return view

    }


}



